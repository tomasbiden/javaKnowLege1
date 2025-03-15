package org.bolin.byteDance;

import java.util.HashMap;

public class P574chi {

    public static int solution(String text) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for(int i=0;i<text.length();i++){
            characterIntegerHashMap.put(text.charAt(i),characterIntegerHashMap.get(text.charAt(i))==null?1:characterIntegerHashMap.get(text.charAt(i))+1);
        }
        Integer one = characterIntegerHashMap.get('c')==null?0:characterIntegerHashMap.get('c');
        Integer two = characterIntegerHashMap.get('h')==null?0:characterIntegerHashMap.get('h');
        Integer three = characterIntegerHashMap.get('i')==null?0:characterIntegerHashMap.get('i');
        int max = Math.min(one, two);
        int max1 = Math.min(max, three);




        return max1;
    }

    public static void main(String[] args) {
        System.out.println(solution("chiichcc") == 2);
        System.out.println(solution("chicchcic") == 2);
        System.out.println(solution("cccchhii") == 2);
    }
}
