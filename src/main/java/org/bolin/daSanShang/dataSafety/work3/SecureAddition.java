package org.bolin.daSanShang.dataSafety.work3;


import java.math.BigInteger;
import java.util.Random;

public class SecureAddition {

    // 模拟生成大于 2^18 的随机数
    public static BigInteger generateGreaterThan2Power18() {
        BigInteger number = new BigInteger(20, new Random()); // 生成一个40位的随机数

        return number;
    }

    public static void main(String[] args) {


        // P1的输入 (x) 和 P2的输入 (y)
        BigInteger x = new BigInteger("32215300007");  // 例如 x = 32215300007
        BigInteger y = new BigInteger("32215300025");  // 例如 y = 32215300025

        // 分割x和y
        // P1生成x = x1 + x2，P2生成y = y1 + y2
        BigInteger x1 = generateGreaterThan2Power18();  // P1生成随机数x1
        BigInteger x2 = x.subtract(x1);  // x2 = x - x1，P1将x2发送给P2

        BigInteger y1 = generateGreaterThan2Power18();  // P2生成随机数y1
        BigInteger y2 = y.subtract(y1);  // y2 = y - y1，P2将y2发送给P1

        // P1和P2交换数据
        System.out.println("P1生成的随机数x1: " + x1);
        System.out.println("P2生成的随机数y1: " + y1);

        System.out.println("P1发送给P2的x2: " + x2);
        System.out.println("P2发送给P1的y2: " + y2);

        // P1计算 [x + y]_1 = x1 + y1
        BigInteger result1 = x1.add(y1);
        // P2计算 [x + y]_2 = x2 + y2
        BigInteger result2 = x2.add(y2);

        // 最终的和是 [x + y]_1 + [x + y]_2
        BigInteger finalResult = result1.add(result2);

        BigInteger realResult=x.add(y);

        System.out.println("计算结果:");
        System.out.println("[x + y]_1 = x1 + y1 = " + result1);
        System.out.println("[x + y]_2 = x2 + y2 = " + result2);
        System.out.println("最终结果 x + y = " + finalResult);
        if(finalResult.equals(realResult)){
            System.out.println("计算结果结果与理论结果相同");
        }


    }
}

