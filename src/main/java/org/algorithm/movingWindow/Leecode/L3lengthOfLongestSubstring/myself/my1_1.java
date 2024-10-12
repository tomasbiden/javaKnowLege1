package org.algorithm.movingWindow.Leecode.L3lengthOfLongestSubstring.myself;

import java.util.HashMap;

public class my1_1 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return  0;
        }
        if(s.length()==1){
            return 1;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int i=0; int j=1;
        int maxLen=1;
        hashMap.put(chars[0],0);
        int len=chars.length;
        while (j<len){
            if(hashMap.containsKey(chars[j])&&hashMap.get(chars[j])>=i){
                i=hashMap.get(chars[j])+1;
                hashMap.replace(chars[j],j);
                j++;
//                Boolean x=true;

            }else {
                hashMap.put(chars[j],j);
                maxLen=Math.max(maxLen,j-i+1);
                j++;
            }
        }
        return  maxLen;



    }
    public  static int test(String str){
        if(str==""){
            return 1;
        }else {
            return  0;
        }
    }
    public  static  void main(String[] args){

        String str1="";
        String str2="";
        System.out.println(str1==str2);     // true
        System.out.println(str1.length());   //  0

        String str3=new String("");
        System.out.println(test(str3));   // 0
        System.out.println(test(str1));  // 1
    }

}
