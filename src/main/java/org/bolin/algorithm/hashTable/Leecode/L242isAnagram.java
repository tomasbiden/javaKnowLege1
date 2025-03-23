package org.bolin.algorithm.hashTable.Leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//有效的字母异位词
public class L242isAnagram {
    public boolean isAnagram_250323_1(String s, String t) {
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(characterIntegerHashMap.containsKey(c)){
                characterIntegerHashMap.replace(c,characterIntegerHashMap.get(c)+1);
            }else {
                characterIntegerHashMap.put(c,1);
            }
        }
        for(int j=0;j<t.length();j++){
            char tc = t.charAt(j);
            if(!characterIntegerHashMap.containsKey(tc)||characterIntegerHashMap.get(tc)==0){
                return false;
            }else {
                characterIntegerHashMap.replace(tc,characterIntegerHashMap.get(tc)-1);
            }

        }
        for (Integer value : characterIntegerHashMap.values()) {
            if(value>0){
                return  false;
            }
        }


        return  true;

    }
}
