package org.bolin.byteDance;

import java.util.HashMap;

public class findOnlyNum {
    private static final  int MAX_NUM=1001;
    public static int solution(int[] cards) {
        // Edit your code here
        HashMap<Integer ,Integer> hashMap = new HashMap<>();
        for (int card : cards) {
            Integer i = hashMap.get(card);
            hashMap.put(card,i+1);

        }
        for (int card : cards) {
            Integer i = hashMap.get(card);
            if(i==1){
                return card;
            }

        }

        return 0;
    }
}
