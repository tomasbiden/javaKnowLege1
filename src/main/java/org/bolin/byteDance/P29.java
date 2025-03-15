package org.bolin.byteDance;

public class P29 {
    public static  String exchange(String s){
        String result=new String();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                result+="bc";
            }else if(s.charAt(i)=='b'){
                result+="ca";
            }else {
                result+="ab";
            }
        }
        return result;
    }
    public static String solution(String s, int k) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        String result=s;
        for(int i=1;i<=k;i++){
            result=exchange(result);
        }
        return result;
    }
}
