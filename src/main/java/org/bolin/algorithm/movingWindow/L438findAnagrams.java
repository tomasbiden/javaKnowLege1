package org.bolin.algorithm.movingWindow;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class  L438findAnagrams_250702_1{
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int[] sCharNum=new int[26];
        int[] pCharNum=new int[26];
        for(int i=0;i<p.length();i++){
            pCharNum[p.charAt(i)-'a']++;
        }
        int left=0;
        for(int right=0;right<s.length();right++){
            sCharNum[s.charAt(right)-'a']++;
            if(right-left+1<p.length()){
                continue;
            }
            if(Arrays.equals(pCharNum,sCharNum)){
                result.add(left);
            }
            sCharNum[s.charAt(left)-'a']--;
//            注意这里不能漏掉了啊
            left++;
        }
        return result;
    }
}
public class L438findAnagrams {
}
