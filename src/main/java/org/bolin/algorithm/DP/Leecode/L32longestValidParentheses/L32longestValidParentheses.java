package org.bolin.algorithm.DP.Leecode.L32longestValidParentheses;

import java.util.Arrays;

class  L32longestValidParentheses_250701_1{
    int maxLen=0;
    public int longestValidParentheses(String s) {
        int[] memory=new int[s.length()];
        Arrays.fill(memory,-1);
//       最后一个不一定会进入递归
        for(int i=s.length()-1;i>=0;i--){
            dfs(i,memory,s);
        }


        return maxLen;
    }

    public int  dfs(int n,int[] memory,String s){
        if(n==-1){
            return 0;
        }
        if(n<1){
            memory[n]=0;
            return memory[n];
        }
        if(memory[n]!=-1){
            return memory[n];
        }
        if(s.charAt(n)==')'&&s.charAt(n-1)=='('){
             memory[n]=dfs(n-2,memory,s)+2;
        }
//      1: 最右边那个不要反了
        if(s.charAt(n)==')'&&s.charAt(n-1)==')'&&dfs(n-1,memory,s)>0&&(n-1-dfs(n-1,memory,s)>=0&&s.charAt(n-1-dfs(n-1,memory,s))=='(')){
            int dfsMiddle = dfs(n - 1, memory, s);
            int dfsQian = dfs(n - 1 - dfs(n - 1, memory, s), memory, s);
//          2:  n-1-dfs(n-1,memory,s)-1  最右边的-1不能漏洞了啊
            memory[n]=dfs(n-1,memory,s)+2+dfs(n-1-dfs(n-1,memory,s)-1,memory,s);
        }
        if(memory[n]==-1){
            memory[n]=0;
        }
        maxLen=Math.max(memory[n],maxLen);
        return memory[n];
    }
    public static void  main(String[] args){
        L32longestValidParentheses_250701_1 l32longestValidParentheses2507011 = new L32longestValidParentheses_250701_1();
        int i = l32longestValidParentheses2507011.longestValidParentheses(")()())()()(");

    }
}

class  L32longestValidParentheses_250701_2{
    public int longestValidParentheses(String s) {
        int maxValue=0;
        int[] result=new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    result[i]=result[i-2]+2;
                }else {
                    if(i-1-result[i-1]>=0&&s.charAt(i-1-result[i-1])=='('){
                        result[i]=result[i-1]+2+(i-1-result[i-1]-1>=0?result[i-1-result[i-1]-1]:0);
                    }
                }
            }
            maxValue=Math.max(result[i],maxValue);
        }
        return maxValue;

    }

    public static void  main(String[] args){
        L32longestValidParentheses_250701_1 l32longestValidParentheses2507011 = new L32longestValidParentheses_250701_1();
        int i = l32longestValidParentheses2507011.longestValidParentheses(")()())()()(");

    }
}
public class L32longestValidParentheses {
}
