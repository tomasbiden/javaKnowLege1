package org.bolin.algorithm.tanXin;

import java.util.ArrayList;
import java.util.List;

class  L763partitionLabels_250710{
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex=new int[26];
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        int start=0;
        int end=0;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            end=Math.max(end,lastIndex[s.charAt(i)-'a']);
            if(end==i){
                result.add(end-start+1);
                start=i+1;
                end=0;
            }
        }
        return result;
    }
}
public class L763partitionLabels {
}
