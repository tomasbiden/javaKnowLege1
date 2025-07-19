package org.bolin.algorithm.backtracking.suiXiangLu.L22generateParenthesis;


import java.util.ArrayList;
import java.util.List;

class L22generateParenthesis_250719_1{
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        dfs(n,new StringBuilder(),0,0,result);
        return  result;

    }
    private void dfs(int n,StringBuilder sb,int leftNum,int rightNum,List<String> result){
        if(leftNum==n&&rightNum==n){
            result.add(sb.toString());
            return;
        }
        if(rightNum<leftNum){
            sb.append(')');
            dfs(n,sb,leftNum, rightNum+1,result );
            sb.deleteCharAt(sb.length()-1);
        }
//       不是小于等于2
        if(leftNum<=n-1){
            sb.append('(');
            dfs(n,sb,leftNum+1,rightNum,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
public class L22generateParenthesis {
}
