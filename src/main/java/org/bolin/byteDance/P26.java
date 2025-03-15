package org.bolin.byteDance;

public class P26 {

    public static int maxNumberAfterInsertion(int a, int b) {
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        String result = "";
        boolean inserted = false;

        for (int i = 0; i < aStr.length(); i++) {
            if (!inserted && bStr.charAt(0) > aStr.charAt(i)) {
                result += bStr;
                inserted = true;
            }
            result += aStr.charAt(i);
        }

        if (!inserted) {
            result += bStr;
        }

        return Integer.valueOf(result);
    }
    public static void main(String[] args){
//        System.out.println(solution(754,3));
    }
}
