package org.bolin.algorithm.DP.Leecode.L1143longestCommonSubsequence;

import java.util.Arrays;

class L1143longestCommonSubsequence_250719{
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memory = new int[text1.length()][text2.length()];
        for(int i=0;i<memory.length;i++){
            Arrays.fill(memory[i],-1);
        }


        return dfs(text1,text2,text1.length()-1,text2.length()-1,memory);
    }

    public int dfs(String text1,String text2, int index1,int index2,int[][] memory){
        if(index1<0||index2<0){
            return 0;
        }
        if(memory[index1][index2]!=-1){
            return  memory[index1][index2];
        }
        if(text1.charAt(index1)==text2.charAt(index2)){
             memory[index1][index2]=dfs(text1,text2,index1-1,index2-1,memory)+1;
        }else{
            memory[index1][index2]=Math.max(dfs(text1,text2,index1-1,index2,memory),dfs(text1,text2,index1,index2-1,memory));
        }
        return memory[index1][index2];
    }
}
public class L1143longestCommonSubsequence {
}
