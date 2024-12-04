package org.bolin.daSanShang.dataSafety.work3;

import java.math.BigInteger;

public class Job3 {
    public static void main(String[] args){
        String xS="3443";
        String yS="3434";

        BigInteger x1 = new BigInteger("12");
        BigInteger x2 = new BigInteger("125");
        BigInteger x = x1.add(x2);

        BigInteger y1 = new BigInteger("1241");
        BigInteger y2 = new BigInteger("125");
        BigInteger y = y1.add(y2);

        BigInteger a1 = new BigInteger("10");
        BigInteger a2 = new BigInteger("15");
        BigInteger a = a1.add(a2);



        BigInteger b1 = new BigInteger("101");
        BigInteger b2 = new BigInteger("151");
        BigInteger b = b1.add(b2);

        BigInteger c=a.multiply(b);
        BigInteger c1 =a1.multiply(b1);
        BigInteger c2 = a2.multiply(b2);

        BigInteger e = x.subtract(a);
        BigInteger f = y.subtract(b);
        BigInteger xy = e.multiply(f)
                .add(f.multiply(a1))
                .add(e.multiply(b1))
                .add(c1);

        BigInteger xy2 = f.multiply(a2).add(e.multiply(b2)).add(c2);
        BigInteger realXY = x.multiply(y);
        System.out.println(xy);
        System.out.println(realXY);
        System.out.println(xy2);

    }
}
