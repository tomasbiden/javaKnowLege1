package org.bolin.algorithm.hashTable.Leecode;

import java.util.*;

class  L49groupAnagrams_250701_1{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>  standardStringsMap=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
//          1：  toString 注意是hashCode的啊
            standardStringsMap.computeIfAbsent(new String(charArray),key-> new ArrayList<>()).add(strs[i]);

        }
        ArrayList<List<String>> lists = new ArrayList<>(standardStringsMap.values());
        return lists;
    }
}
public class L49groupAnagrams {
}
