package org.bolin.byteDance;

public class P48 {
    public static String solution(String s) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='a'){
               stringBuffer.append("%100");
           }else {
               stringBuffer.append(s.charAt(i));
           }
       }
        return  stringBuffer.toString();
    }
}
