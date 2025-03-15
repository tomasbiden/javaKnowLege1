package org.bolin.byteDance;

import java.util.HashMap;

public class P8 {
    public static int solution(int[] array) {
        // Edit your code here
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int length = array.length;
        for (int i : array) {
            Integer i1 = hashMap.get(i);
            hashMap.put(i,i1==null?1:i1+1);
            if(i1+1>=(length+1)/2){
                return i;
            }


        }


        return 0;
    }
}
