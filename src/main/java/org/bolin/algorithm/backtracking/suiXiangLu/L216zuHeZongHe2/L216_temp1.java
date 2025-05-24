package org.bolin.algorithm.backtracking.suiXiangLu.L216zuHeZongHe2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L216_temp1 {
    List<List<Integer>> result=new ArrayList<>();

    LinkedList<Integer> path=new LinkedList<>();

    int sum=0;

    public void backTracking(int[] arr,int startIndex,int n,int k){
//        漏掉了 path.size==k进行return 导致了空异常了啊
        if(sum>n){
            return;
        }
        if(path.size()==k){
            if(sum==n) result.add(new ArrayList<>(path));
            return;
        }

//       1: arr.length-i+path.size()<k 错误 必须够用才行啊
//        2:需要有   arr.length防止空异常
//        3： i=0粗错误 i=startIndex才正确啊
        for(int i = startIndex;  arr.length-i+path.size()>=k; i++){
            path.add(arr[i]);
            sum+=arr[i];
            backTracking(arr,i+1,n,k);
            sum-=arr[i];
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
            int[] arr=new int[9];
            for(int i=0;i<arr.length;i++){
                arr[i]=i+1;
            }
            backTracking(arr,0,n,k);
            return result;
    }
    public static void main(String[] args){
        int k=3;int n=7;
        L216_temp1 l2162505241 = new L216_temp1();
        for (List<Integer> integers : l2162505241.combinationSum3(k, n)) {
            System.out.println(integers);
        }


    }
}
