package org.bolin.byteDance;

public class P581 {

    public static int solution(int n, int start) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        int result=start;
        for(int i=2;i<=(n+n-2);i=i+2){
            result^=(start+i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(12, 3) == 24);
        System.out.println(solution(20, 16) == 0);
        System.out.println(solution(18, 9) == 2);
        System.out.println(solution(7, 1) == 15);
    }
}
