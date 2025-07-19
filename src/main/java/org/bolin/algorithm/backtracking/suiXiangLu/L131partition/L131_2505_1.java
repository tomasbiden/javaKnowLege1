package org.bolin.algorithm.backtracking.suiXiangLu.L131partition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class L131partition_250719_1{
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        dfs(s,0,new ArrayList<>(),result);
        return result;
    }

    private boolean checkValid(String s,int start,int end){
        while (start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    private void dfs(String s,int start,List<String> path,List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(path));
        }
        for(int i=start;i<s.length();i++){
            if(checkValid(s,start,i)){
                path.add(s.substring(start,i+1));
                dfs(s,i+1,path,result);
                path.remove(path.size()-1);
            }
        }
    }
}
class Partition_250629_1{

    List<String> path=new ArrayList<>();

    List<List<String>> result=new ArrayList<>();

    public boolean checkValid(int start,int end,String s){

        for(int i=start,j=end-1;i<=j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public void traversal(String s, int start){
        if(start>=s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<s.length();i++){
//           注意是i+1
            if(checkValid(start,i+1,s)){
                path.add(s.substring(start,i+1));
                traversal(s,i+1);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        traversal(s,0);
        return result;

    }
    public static void main(String[] args){
        Partition_250629_1 partition2506291 = new Partition_250629_1();
        List<List<String>> aab = partition2506291.partition("aab");


    }

}
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
