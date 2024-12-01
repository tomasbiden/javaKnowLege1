package org.bolin.daSanShang.dataSafety.work1;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
    private static BigInteger p, q, n, phi, e, d;
    private final int bitLength = 33; // 密钥长度

    // 使用 BigInteger 来表示 2^32
   private static BigInteger  lowBound = BigInteger.valueOf(2).pow(32); // 等同于 2^32

    // 构造函数，生成密钥对
    public RSA(String studentID) {
        String reversedLastThree = getLastThreeReversed(studentID); // 学号后三位倒序

        q = BigInteger.probablePrime(bitLength, new SecureRandom()); // 随机生成大素数 q
        p = generatePrimeFromLastThree(reversedLastThree); // 根据学号生成素数 p
        n = p.multiply(q); // n = p * q
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); // φ(n) = (p-1)*(q-1)
        e = BigInteger.probablePrime(bitLength / 2, new SecureRandom()); // 生成公钥指数 e
        while (phi.gcd(e).intValue() > 1) {
            e = e.add(BigInteger.ONE); // 保证 e 与 φ(n) 互质
        }
        d = e.modInverse(phi); // 计算私钥 d
    }

    // 获取学号后三位并倒序
    private String getLastThreeReversed(String studentID) {
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
//        long cur=Long.parseLong(reversedLastThree);
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

    private BigInteger generatePrimeFromStudentId(String studentId) {
        String reversedLastThree=getLastThreeReversed(studentId);
        // 添加足够的位数
//        long cur=Long.parseLong(reversedLastThree);
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



    // 加密
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    // 解密
    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(d, n);
    }

    // 进行同态乘法计算
    public BigInteger homomorphicMultiplication(BigInteger ciphertext1, BigInteger ciphertext2) {
        return ciphertext1.multiply(ciphertext2).mod(n); // 同态乘法
    }

    public static void main(String[] args) {

        String studentID = "32215300007";
        RSA rsa = new RSA(studentID);

        // 明文 m1 和 m2
        BigInteger m1 = new BigInteger(rsa.getLastThreeReversed(studentID));
        System.out.println("p:"+p +" q:"+q);
        System.out.println("公钥对：(n:"+n+" e:"+e+")");
        System.out.println("密钥对：(n:"+n+" d:"+d+")");

        if(p.compareTo(lowBound)==1&&q.compareTo(lowBound)==1){
            System.out.println("p 和 q 都大于 2^32");
        }

//        m1=new BigInteger("190");
        System.out.println("明文m1:"+m1);
        BigInteger m2 = m1.add(BigInteger.valueOf(18)); // m2 = m1 + 18
        System.out.println("明文m2:"+m2);


        // 加密
        BigInteger c1 = rsa.encrypt(m1);
        BigInteger c2 = rsa.encrypt(m2);
        System.out.println("密文 c1: " + c1);
        System.out.println("密文 c2: " + c2);

        // 解密
        BigInteger decryptedM1 = rsa.decrypt(c1);
        BigInteger decryptedM2 = rsa.decrypt(c2);
        System.out.println("解密后的 m1: " + decryptedM1);
        System.out.println("解密后的 m2: " + decryptedM2);

        // 同态乘法验证
        BigInteger homomorphicResult = rsa.homomorphicMultiplication(c1, c2);
        BigInteger decryptedResult = rsa.decrypt(homomorphicResult);
        System.out.println("同态乘法解密后为: " + decryptedResult);
        System.out.println("实际应该得到的结果为 " + m1.multiply(m2));
    }
}
