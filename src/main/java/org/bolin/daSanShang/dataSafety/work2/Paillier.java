package org.bolin.daSanShang.dataSafety.work2;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Paillier {
    private BigInteger p, q, n, nsquare, g, lambda, mu;
//    密钥长度
    private int bitLength;

    //  p,q的下限
    private BigInteger  lowBound ;

    // 构造函数，初始化密钥参数
    public Paillier(int bitLength) {
        this.bitLength = bitLength;
        lowBound = BigInteger.valueOf(2).pow(bitLength);
    }

    // 1. 密钥生成
    public void keyGeneration(String studentIdReversed) {
        SecureRandom random = new SecureRandom();


        p=generatePrimeFromLastThree(studentIdReversed);


        q = BigInteger.probablePrime(bitLength, new SecureRandom()); // 随机生成大素数 q


        n = p.multiply(q); // n = p * q
        nsquare = n.multiply(n); // n^2
        g = new BigInteger(bitLength, random).mod(nsquare); // 选择 g

        lambda = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))
                .divide(p.subtract(BigInteger.ONE).gcd(q.subtract(BigInteger.ONE))); // 计算 λ
        mu = g.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).modInverse(n); // 计算 μ
    }

    // 2. 数据加密
    public BigInteger encrypt(BigInteger m) {
        SecureRandom random = new SecureRandom();
        BigInteger r = new BigInteger(bitLength, random).mod(n); // 生成随机数 r
        while (r.equals(BigInteger.ZERO)) {
            r = new BigInteger(bitLength, random).mod(n);
        }

        // c = g^m * r^n mod n^2
        return g.modPow(m, nsquare).multiply(r.modPow(n, nsquare)).mod(nsquare);
    }

    // 3. 数据解密
    public BigInteger decrypt(BigInteger c) {
        // u = c^λ mod n^2
        BigInteger u = c.modPow(lambda, nsquare);
        // L(u) = (u - 1) / n
        BigInteger l = u.subtract(BigInteger.ONE).divide(n);
        // m = L(u) * μ mod n
        return l.multiply(mu).mod(n);
    }

    // 4. 同态加法
    public BigInteger homomorphicAdd(BigInteger c1, BigInteger c2) {
        return c1.multiply(c2).mod(nsquare); // c_add = c1 * c2 mod n^2
    }


    // 获取学号后三位并倒序
    private static String getLastThreeReversed(String studentID) {
        String lastThree = studentID.substring(studentID.length() - 3);

        StringBuilder reversed = new StringBuilder(lastThree).reverse();
        if (reversed.charAt(0) == '0') {
            reversed.setCharAt(0, '1'); // 如果倒序后最后一位为 0，改为 1
        }
        return reversed.toString();
    }

    // 根据倒序后三位生成 p
    private BigInteger generatePrimeFromLastThree(String reversedLastThree) {

        // 添加足够的位数
        BigInteger cur=new BigInteger(reversedLastThree);


        while (cur.compareTo(lowBound)==-1){
//            注意要赋值啊
            cur=cur.multiply(BigInteger.valueOf(10));

        }

        while (!cur.isProbablePrime(20)){
//            注意要赋值啊
            cur= cur.add(BigInteger.valueOf(1));

        }
        return cur;
    }



    // 主方法，测试实验
    public static void main(String[] args) {
        // 学号后三位倒序（如最后一位是0，设置为1）
        String studentId = "32215300007";
        String lastThreeReversed = getLastThreeReversed(studentId);



        // 实例化 Paillier
        Paillier paillier = new Paillier(19); // 密钥长度19位
        paillier.keyGeneration(lastThreeReversed );

        // 明文数据
        BigInteger m1 = new BigInteger(lastThreeReversed); // 明文 m1
        BigInteger m2 = m1.add(BigInteger.valueOf(18)); // 明文 m2 = m1 + 18

        // 加密过程
        BigInteger c1 = paillier.encrypt(m1);
        BigInteger c2 = paillier.encrypt(m2);

        // 解密过程
        BigInteger decryptedM1 = paillier.decrypt(c1);
        BigInteger decryptedM2 = paillier.decrypt(c2);

        // 同态加法验证
        BigInteger cAdd = paillier.homomorphicAdd(c1, c2); // c_add = c1 * c2 mod n^2
        BigInteger decryptedAdd = paillier.decrypt(cAdd); // 解密 c_add

        // 输出结果
        System.out.println("p: " + paillier.p);
        System.out.println("q: " + paillier.q);
        System.out.println("n: " + paillier.n);
        System.out.println("明文m1: " + m1 + ", 明文m2: " + m2);
        System.out.println("密文m1: " + c1);
        System.out.println("密文 m2: " + c2);
        System.out.println("解密后的m1: " + decryptedM1);
        System.out.println("解密后的 m2: " + decryptedM2);
        System.out.println("同台加法后解密的结果为: " + decryptedAdd);
    }
}

