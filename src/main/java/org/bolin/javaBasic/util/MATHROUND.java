package org.bolin.javaBasic.util;

public class MATHROUND {
    public static void main(String[] args){
        double arg1 = 1.91452452000000474;
//        gpt推荐
        double result = Math.round(arg1 * 100.0) / 100.0;
        double result2 = Math.round(arg1 * 100.0) /100;
//        错误
        double result3 = Math.round(arg1 * 100.0) *0.01d;
        long round = Math.round(arg1 * 100.0);
        double result4 = round * 0.01d;
        System.out.println(result);
        System.out.println(result2);  // 输出: 3.14
        System.out.println(result3);
        System.out.println(round);
        System.out.println(result4);



    }
}
