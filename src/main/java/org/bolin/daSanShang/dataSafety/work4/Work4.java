package org.bolin.daSanShang.dataSafety.work4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Work4 {

    // 生成两个大素数并计算公钥和私钥
    public static class RSAKeyPair {
        BigInteger publicKey;
        BigInteger privateKey;
        BigInteger modulus;

        public RSAKeyPair(BigInteger publicKey, BigInteger privateKey, BigInteger modulus) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
            this.modulus = modulus;
        }
    }

    // 计算最大公约数
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }

    // 求模反元素，即求d，使得 e*d ≡ 1 (mod φ(n))
    public static BigInteger modInverse(BigInteger a, BigInteger m) {
        return a.modInverse(m);
    }

    // 生成密钥对
    public static RSAKeyPair generateKeyPair() {
        // 选取两个素数p和q
        BigInteger p = BigInteger.probablePrime(512, new Random()); // 生成512位的大素数
        BigInteger q = BigInteger.probablePrime(512, new Random()); // 生成512位的大素数

        // 计算n = p * q
        BigInteger n = p.multiply(q);

        // 计算欧拉函数 φ(n)
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // 选择公钥e，要求 1 < e < φ(n) 且 gcd(e, φ(n)) = 1
        BigInteger e = BigInteger.valueOf(65537); // 常用的公钥e值

        // 计算私钥d，使得 d * e ≡ 1 (mod φ(n))
        BigInteger d = modInverse(e, phi);

        return new RSAKeyPair(e, d, n);
    }

    // 加密
    public static BigInteger encrypt(BigInteger message, BigInteger e, BigInteger n) {
        return message.modPow(e, n); // C = M^e (mod n)
    }

    // 解密
    public static BigInteger decrypt(BigInteger ciphertext, BigInteger d, BigInteger n) {
        return ciphertext.modPow(d, n); // M = C^d (mod n)
    }

    public static void main(String[] args) {
        // 生成密钥对
        RSAKeyPair keyPair = generateKeyPair();
        BigInteger publicKey = keyPair.publicKey;
        BigInteger privateKey = keyPair.privateKey;
        BigInteger modulus = keyPair.modulus;


//      x为A选择的随机数，i为A的数字，j为B的数字
        BigInteger x=new BigInteger("92");
        BigInteger i=new BigInteger("00007");
        BigInteger j=new BigInteger("00025");
//        A 将 E(x)-i的值发送给B
        BigInteger encrypt = encrypt(x, publicKey, modulus);
        BigInteger ExSubI=encrypt.subtract(i);

//      计算 y= D(E(x)-i+u) ,u的取值范围为[1-N]
        ArrayList<BigInteger> yArrayList = new ArrayList<>();
        BigInteger m=new BigInteger("1");
        BigInteger N=j.subtract(i).add(BigInteger.ONE);
        for(m=new BigInteger("1");m.compareTo(N)==-1;m=m.add(BigInteger.ONE)){
           yArrayList.add(decrypt(ExSubI.add(m),privateKey,modulus));
        }
//      对解密得到的结果进行 mod(P)，且若 m>j则要进行+1操作
        ArrayList<BigInteger> zArrayList= new ArrayList<>();
        BigInteger P = new BigInteger("109");
        for(m=new BigInteger("0");m.compareTo(N.subtract(BigInteger.ONE))==-1;m=m.add(BigInteger.ONE)){
            if(m.compareTo(j)==1){
                zArrayList.add(yArrayList.get(m.intValue()).mod(P).add(BigInteger.ONE));
            }else {
                zArrayList.add(yArrayList.get(m.intValue()).mod(P));
            }

        }
//      最后 A 拿到第 Zi 看 是否与x 同余，若是则说明 i<j否则 i>j
        BigInteger Zi = zArrayList.get((i.subtract(BigInteger.ONE)).intValue());
        if(Zi.mod(P).equals(x.mod(P))){
            System.out.println("i<j");
        }else {
            System.out.println("i>j");
        }




    }
}
