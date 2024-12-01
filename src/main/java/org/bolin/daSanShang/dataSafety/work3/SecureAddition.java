package org.bolin.daSanShang.dataSafety.work3;

import java.math.BigInteger;

public class SecureAddition {

    // 模拟加密
    public static BigInteger encrypt(BigInteger data, BigInteger key) {
        return data.add(key); // 简单加法加密
    }

    // 模拟解密
    public static BigInteger decrypt(BigInteger encryptedData, BigInteger key) {
        return encryptedData.subtract(key); // 解密为原数据
    }

    public static void main(String[] args) {
        BigInteger aliceInput = new BigInteger("12345");  // Alice的学号
        BigInteger bobInput = aliceInput.add(new BigInteger("18"));  // Bob的学号，假设为学号 + 18

        BigInteger encryptionKey = new BigInteger("1000");  // 简单的加密密钥

        // Alice和Bob都加密自己的输入
        BigInteger aliceEncrypted = encrypt(aliceInput, encryptionKey);
        BigInteger bobEncrypted = encrypt(bobInput, encryptionKey);

        System.out.println("Alice加密后的数据：" + aliceEncrypted);
        System.out.println("Bob加密后的数据：" + bobEncrypted);

        // Alice和Bob交换加密数据后，相加得到最终结果
        BigInteger encryptedSum = aliceEncrypted.add(bobEncrypted);

        // 解密结果
        BigInteger sum = decrypt(encryptedSum, encryptionKey);
        System.out.println("计算结果：" + sum);
    }
}
