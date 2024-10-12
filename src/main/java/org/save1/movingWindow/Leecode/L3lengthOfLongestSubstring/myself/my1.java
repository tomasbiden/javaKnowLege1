package org.save1.movingWindow.Leecode.L3lengthOfLongestSubstring.myself;

import java.util.HashMap;

public class my1 {
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
//        初始置为1，因为最低为1
        int maxLen=1;
        hashMap.put(chars[0],0);
        int len=chars.length;
        while (j<len){
            if(hashMap.containsKey(chars[j])&&hashMap.get(chars[j])>=i){

//                i=hashMap.get(chars[i])+1;

                i=hashMap.get(chars[j])+1;
//                这里能重复的 不只能为i的值啊



//                这个更新不能漏掉啊
                hashMap.replace(chars[j],j);
                j++;

            }else {

//                注意加入到Map中的不能漏掉啊
                hashMap.put(chars[j],j);
                maxLen=Math.max(maxLen,j-i+1);
//                这个不能漏掉啊，迭代条件
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
