package org.bolin.algorithm.DP.Leecode.L139wordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class L139wordBreak_250716_1{
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet=new HashSet<>();
        int wordMaxLen=0;
        for(String word : wordDict){
            wordMaxLen=Math.max(wordMaxLen,word.length());
            wordSet.add(word);
        }
        int[] memory=new int[s.length()];
        Arrays.fill(memory,-1);
        return dfs(s,s.length()-1,wordSet,wordMaxLen,memory);
    }
    private boolean dfs(String s,int n,Set<String> wordSet,int wordMaxLen,int[] memory){
//       注意临界判断
        if(n<0){
            return true;
        }
        if(memory[n]!=-1){
            return memory[n]==1;
        }
        for(int i=n;(i>=0&&i>n-wordMaxLen);i--){
            if(wordSet.contains(s.substring(i,n+1))&&dfs(s,i-1,wordSet,wordMaxLen,memory)){
//               注意要提前返回的啊
                memory[n]=1;
                return true;
            }
        }
        memory[n]=0;
        return false;

    }
    public static void main(String[] args){
        L139wordBreak_250716_1 l139wordBreak2507161 = new L139wordBreak_250716_1();
        boolean b = l139wordBreak2507161.wordBreak("leetcode", Arrays.asList("leet", "code"));

    }
}
class L139wordBreak_250709_1{
    public boolean wordBreak(String s, List<String> wordDict) {
        int wordDictMaxLen=1;
        for(int i=0;i<wordDict.size();i++){
            wordDictMaxLen=Math.max(wordDictMaxLen,wordDict.get(i).length());
        }
        Set<String> wordSet=new HashSet<>(wordDict);
//       2:注意越界问题
        int[] memeory=new int[s.length()+1];
//        注意初始填充
        Arrays.fill(memeory,-1);
        return  dfs(s,s.length(),wordDictMaxLen,wordSet,memeory);
    }
    private boolean  dfs(String s,int charEnd,int wordDictMaxLen,Set<String> wordSet,int[] memory){
//       注意递归结束条件
        if(charEnd==0){
            return true;
        }
        if(memory[charEnd]!=-1){
            return memory[charEnd]==1;
        }
        for(int j=charEnd-1;j>=Math.max(0,charEnd-wordDictMaxLen);j--){
            String substring = s.substring(j, charEnd);
            if(wordSet.contains(substring)&&dfs(s,j,wordDictMaxLen,wordSet,memory)){
//                memory[j] 错误
                memory[charEnd]=1;
                return memory[charEnd]==1;
            }

        }
        memory[charEnd]=0;
        return memory[charEnd]==1;
    }
    public static void main(String[] args){
        L139wordBreak_250709_1 l139wordBreak2507091 = new L139wordBreak_250709_1();
        l139wordBreak2507091.wordBreak("leetcode",Arrays.asList("leet","code"));

    }
}
public class L139wordBreak {
}
