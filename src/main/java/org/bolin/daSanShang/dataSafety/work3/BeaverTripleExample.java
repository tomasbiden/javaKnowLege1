package org.bolin.daSanShang.dataSafety.work3;

import java.math.BigInteger;
import java.util.Random;

public class BeaverTripleExample {

    // Paillier 加密的简化模拟类，实际代码中应使用具体的加密库
    static class Paillier {
        BigInteger n; // 公钥n
        BigInteger g; // 公钥g
        BigInteger lambda; // 私钥lambda
        BigInteger mu; // 私钥mu

        // 构造函数，生成Paillier加密所需的参数
        public Paillier(BigInteger n, BigInteger g, BigInteger lambda, BigInteger mu) {
            this.n = n;
            this.g = g;
            this.lambda = lambda;
            this.mu = mu;
        }

        // 加密函数
        public BigInteger encrypt(BigInteger m) {
            Random rand = new Random();
            BigInteger r = new BigInteger(n.bitLength(), rand); // 随机数r
            r = r.mod(n); // 确保r < n
            BigInteger ciphertext = g.modPow(m, n.multiply(n)).multiply(r.modPow(n, n.multiply(n))).mod(n.multiply(n));
            return ciphertext;
        }

        // 解密函数
        public BigInteger decrypt(BigInteger c) {
            BigInteger u = c.modPow(lambda, n.multiply(n)).subtract(BigInteger.ONE).divide(n).multiply(mu).mod(n);
            return u;
        }
    }

    // 生成乘法三元组
    public static void generateBeaverTriple(Paillier paillier, BigInteger a1, BigInteger b1, BigInteger a2, BigInteger b2) {
        // P1 的加密操作
        BigInteger Enc_a1 = paillier.encrypt(a1);
        BigInteger Enc_b1 = paillier.encrypt(b1);
        System.out.println("P1 sends Enc(a1): " + Enc_a1 + ", Enc(b1): " + Enc_b1);

        // P2 生成随机数 r，并计算 d
        Random rand = new Random();
        BigInteger r = new BigInteger(paillier.n.bitLength(), rand);
        BigInteger d = Enc_a1.modPow(b2, paillier.n.multiply(paillier.n))
                .multiply(Enc_b1.modPow(a2, paillier.n.multiply(paillier.n)))
                .multiply(paillier.encrypt(r))
                .mod(paillier.n.multiply(paillier.n));
        System.out.println("P2 sends d: " + d);

        // P1 计算 c1
        BigInteger c1 = a1.multiply(b1).add(paillier.decrypt(d));
        System.out.println("P1 computes c1: " + c1);

        // P2 计算 c2
        BigInteger c2 = a2.multiply(b2).subtract(r);
        System.out.println("P2 computes c2: " + c2);
    }

    public static void main(String[] args) {
        // Paillier加密所需的参数 n, g, lambda, mu
        BigInteger n = new BigInteger("11"); // 简单的素数
        BigInteger g = new BigInteger("2");
        BigInteger lambda = new BigInteger("5");
        BigInteger mu = new BigInteger("6");
        
        Paillier paillier = new Paillier(n, g, lambda, mu);

        // 输入值 a1, b1, a2, b2
        BigInteger a1 = new BigInteger("3");
        BigInteger b1 = new BigInteger("4");
        BigInteger a2 = new BigInteger("2");
        BigInteger b2 = new BigInteger("5");

        // 生成 Beaver 三元组
        generateBeaverTriple(paillier, a1, b1, a2, b2);
    }
}
