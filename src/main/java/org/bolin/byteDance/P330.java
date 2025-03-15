package org.bolin.byteDance;

import java.util.ArrayList;

public class P330 {
    public static int solution(int N) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        if(N==0){
            return 1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int x=N;
        while (x!=0){
            list.add(x%2);
            x/=2;
        }
        for(int i=0;i<list.size();i++){
            list.set(i,list.get(i)==1?0:1);
        }
        int result=0;

        int num=1;
        for (Integer i : list) {
            if(i==1){
                result+=num;
            }
            num*=2;
        }
        return result;

    }
    public static void main(String[] args) {
        System.out.println(solution(5) == 2 ? 1 : 0);
        System.out.println(solution(10) == 5 ? 1 : 0);
        System.out.println(solution(0) == 1 ? 1 : 0);
    }
}
