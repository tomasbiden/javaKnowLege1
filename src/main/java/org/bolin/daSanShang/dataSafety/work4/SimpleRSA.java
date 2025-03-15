package org.bolin.daSanShang.dataSafety.work4;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class SimpleRSA {

    public static void main(String[] args) {
        try {
            // 生成 RSA 密钥对
            RSAKeyPair keyPair = generateKeyPair();

            // 公钥和私钥
            BigInteger publicKey = keyPair.publicKey;
            BigInteger privateKey = keyPair.privateKey;
            BigInteger modulus = keyPair.modulus;

            // 要加密的原始数据
            String message = "Hello, RSA!";
            System.out.println("Original Message: " + message);

            // 加密数据
            String encryptedMessage = encrypt(message, publicKey, modulus);
            System.out.println("Encrypted Message: " + encryptedMessage);

            // 解密数据
            String decryptedMessage = decrypt(encryptedMessage, privateKey, modulus);
            System.out.println("Decrypted Message: " + decryptedMessage);

//            分割线
            BigInteger n=new BigInteger("92");
            String encrypt = encrypt(n.toString(), publicKey, modulus);
            BigInteger x=new BigInteger("9");
            BigInteger ExSubx=new BigInteger(encrypt).subtract(x);
            BigInteger u=new BigInteger("10");
            BigInteger i=new BigInteger("1");
            ArrayList<BigInteger> yArrayList = new ArrayList<>();
            for(i=new BigInteger("1");i.compareTo(u)==-1;i=i.add(BigInteger.ONE)){
                BigInteger bigInteger = new BigInteger(decrypt(ExSubx.add(i).toString(), privateKey, modulus).getBytes());
                yArrayList.add(bigInteger);
            }

            ArrayList<BigInteger> zArrayList = new ArrayList<>();
            for(i=new BigInteger("1");i.compareTo(u)==-1;i.add(BigInteger.ONE)){
                yArrayList.add(new BigInteger(decrypt(ExSubx.add(i).toString(),privateKey,modulus)));
            }
            System.out.println(yArrayList.get(8));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 生成 RSA 密钥对
    public static RSAKeyPair generateKeyPair() {
        SecureRandom random = new SecureRandom();
        
        // 生成两个大素数 p 和 q
        BigInteger p = new BigInteger(512, 100, random); // 512 位素数
        BigInteger q = new BigInteger(512, 100, random); // 512 位素数
        
        // 计算模数 n = p * q
        BigInteger n = p.multiply(q);

        // 计算 φ(n) = (p-1) * (q-1)
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        // 选择公钥 e，通常选择一个较小的奇数，且 e 与 φ(n) 互质
        BigInteger e = new BigInteger("65537"); // 常用公钥 e

        // 计算私钥 d，使得 e * d ≡ 1 (mod φ(n))
        BigInteger d = e.modInverse(phi);

        return new RSAKeyPair(e, d, n);
    }

    // 加密方法
    public static String encrypt(String message, BigInteger publicKey, BigInteger modulus) {
        BigInteger messageBigInt = new BigInteger(message.getBytes());
        BigInteger encryptedMessage = messageBigInt.modPow(publicKey, modulus);
        return encryptedMessage.toString();
    }

    // 解密方法
    public static String decrypt(String encryptedMessage, BigInteger privateKey, BigInteger modulus) {
        BigInteger encryptedBigInt = new BigInteger(encryptedMessage);
        BigInteger decryptedMessage = encryptedBigInt.modPow(privateKey, modulus);
        return new String(decryptedMessage.toByteArray());
    }

    // RSA 密钥对类
    static class RSAKeyPair {
        BigInteger publicKey;
        BigInteger privateKey;
        BigInteger modulus;

        public RSAKeyPair(BigInteger publicKey, BigInteger privateKey, BigInteger modulus) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
            this.modulus = modulus;
        }
    }
}
