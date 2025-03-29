package org.bolin.algorithm.String1.group1;

import jodd.util.CollectionUtil;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class L151reverseWords {
    public String reverseWords_250329_1(String s) {
        ArrayList<String> strings = new ArrayList<>();
        for(int i=0;i<s.length();i++){
                StringBuilder stringBuilder = new StringBuilder();
//         3       缺少i<s.length()错误
                while (i<s.length()&&s.charAt(i)!=' '){

                    stringBuilder.append(s.charAt(i));
//           2         while 缺少i++错误
                    i++;
                }
                if(stringBuilder.length()>0){
                    strings.add(stringBuilder.toString());
                }


        }
        StringBuilder result = new StringBuilder();
//    1    i++ 错误   4 缺少-1错误
        for(int i=strings.size()-1;i>=0;i--){
            if(i!=strings.size()-1){
                result.append(' ');
            }
            result.append(strings.get(i));
        }
//        5 strings.toString(); 错误
        return  result.toString();
        /*
        int firstIndex=0;
        int lastIndex=strings.size()-1;

        while (firstIndex<lastIndex){
            String tmp=new String(strings.get(firstIndex));
            strings.set(firstIndex,strings.get(lastIndex));
            strings.set(lastIndex,tmp);
        }

         */





    }
}
