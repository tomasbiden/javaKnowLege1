package org.bolin.byteDance;

public class P44 {
    public static int solution(int x, int y) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        int r= (int) Math.ceil(Math.sqrt((x*x)+(y*y)));
        int score=11-r;
        score=score<=0?0:score;
        return score;



    }

    public static void main(String[] args) {
        System.out.println(solution(1, 0) == 10);
        System.out.println(solution(1, 1) == 9);
        System.out.println(solution(0, 5) == 6);
        System.out.println(solution(3, 4) == 6);
    }
}
