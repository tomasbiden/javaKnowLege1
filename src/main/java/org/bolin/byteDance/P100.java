package org.bolin.byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P100 {

    public static int solution2(int[] A) {
        // Edit your code here
        int len=A.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(A[i]);
        }
        Collections.sort(list);
        int result=0;
        for(int i=0;i<len;i++){
            int greater=0;
            int jSave=0;
            for(int j=i+1;j<len&&list.get(j)==list.get(i);j++){
                jSave=j;

            }
            if(jSave==0){
                greater=0;
            }else {
                greater=(len-1)-jSave+1;
            }

            int lower=-2;
            int zSave=i-1;

            for(int z=zSave;z>=0&&zSave==list.get(z);z--){
                zSave=z;
            }
            if(zSave==-2){
                lower=0;
            }else {
                lower=(i-1)-zSave+1;

            }

            if(lower>greater){
                result++;
            }

        }


        return result;
    }

    public static int solution(int[] A) {
        int n = A.length;
        int result = 0;
        Arrays.sort(A);

        for (int i = 0; i < n; i++) {
            int lower = 0;
            int greater = 0;

            for (int j = 0; j < n; j++) {
                if (A[j] <= A[i]) lower++;
                if (A[j] > A[i]) greater++;
            }

            if (lower > greater) result++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(new int[]{100, 100, 100}) == 3);
        System.out.println(solution(new int[]{2, 1, 3}) == 2);
        System.out.println(solution(new int[]{30, 1, 30, 30}) == 3);
        System.out.println(solution(new int[]{19, 27, 73, 55, 88}) == 3);
        System.out.println(solution(new int[]{19, 27, 73, 55, 88, 88, 2, 17, 22}) == 5);
    }
}
