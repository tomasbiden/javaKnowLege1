package org.bolin.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class First {
    public static List<String> stringSplict(String str){
        ArrayList<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='&'&&stringBuilder.length()>0){
                res.add(stringBuilder.toString());
                stringBuilder.delete(0,stringBuilder.length());
                continue;

            }
            if(str.charAt(i)!='&'){
                stringBuilder.append(str.charAt(i));
            }
        }
        if(stringBuilder.length()>0){
            res.add(stringBuilder.toString());
            stringBuilder.delete(0,stringBuilder.length());

        }
        return res;

    }
    public static  String arrayToString(String[] strs){
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
            stringBuilder.append("&&");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        return stringBuilder.toString();

    }
    public static void main(String[] args){
        String str="ab&&2";
        List<String> strings = stringSplict(str);
        System.out.println(strings);

        String[] strs={"ab","2"};
        String s = arrayToString(strs);
        System.out.println(s);



    }
}
