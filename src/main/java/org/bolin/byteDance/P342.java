package org.bolin.byteDance;

public class P342 {
    public static String solution(int n, int x, int[] a) {
    // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
    // write code here
    Double doubleSum= (double) 0;
    for(int i=1;i<=n;i++){
        doubleSum+=a[i-1];
    }
    doubleSum=doubleSum/(4.0*x);
//    doubleSum=Math.(doubleSum* 100) / 100.0;
    String formattedResult = String.format("%.2f", doubleSum);
        double v = Double.parseDouble(formattedResult);
        return formattedResult;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 4, new int[]{90}).equals("3.50"));
        System.out.println(solution(3, 2, new int[]{4, 6, 8}).equals("2.25"));
        System.out.println(solution(2, 1, new int[]{10, 5}).equals("3.75"));
    }
}
