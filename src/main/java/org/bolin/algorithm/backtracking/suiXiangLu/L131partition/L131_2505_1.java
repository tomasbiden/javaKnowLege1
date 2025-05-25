package org.bolin.algorithm.backtracking.suiXiangLu.L131partition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L131_2505_1 {

    List<List<String>> result=new ArrayList<>();
    LinkedList<String> path=new LinkedList<>();

    public boolean check(String s, int i,int j){
//        1:m=0错误 m=i
//        2:必须要+1
//        3:m< (j-i+1) /2错误 m<(j+i+1)/2 正确
        for(int m=i;m<(j+i+1)/2;m++){
            if(s.charAt(m)==s.charAt(j-(m-i))){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    public void backTracking(String s,int startIndex){
        if(startIndex>=s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(check(s,startIndex,i)){
                path.add(s.substring(startIndex,i+1));
                backTracking(s,i+1);
                path.removeLast();
            }
        }
    }
    public List<List<String>> partition(String s) {
        if(s==null||s.length()==0){
            return result;
        }
        backTracking(s,0);
        return result;
    }
    public static void main(String[] args){
        String s="xabcba";
        L131_2505_1 l13125051 = new L131_2505_1();
        boolean check = l13125051.check(s, 1, 5);
        for (List<String> aab : l13125051.partition(new String("aab"))) {
            System.out.println(aab);
        }


    }
}
