package org.bolin.algorithm.backtracking.suiXiangLu.L22generateParenthesis;


import java.util.ArrayList;
import java.util.List;

class T250629_1{
    StringBuilder sb=new StringBuilder();

    List<String> result=new ArrayList<>();


    public void traversal(int n,int i,int open){
        if(i==2*n){
            result.add(sb.toString());

        }
        if(open<n){
            sb.append('(');
            traversal(n,i+1,open+1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(i-open<open){
            sb.append(')');
            traversal(n,i+1,open);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {

            traversal(n,0,0);
            return result;


    }
    public static void main(String[] args){
        T250629_1 t2506291 = new T250629_1();
        List<String> strings = t2506291.generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
public class GenerateParenthesis
{
}
