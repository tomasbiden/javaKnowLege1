package org.bolin.algorithm.backtracking.suiXiangLu.L39combinationSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L39_250524_1 {
    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    int sum=0;
    public void backTracking(int[] arr,int startIndex,int target){

        if(sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<arr.length&&sum<target;i++){
            path.add(arr[i]);
            sum+=arr[i];
            backTracking(arr,i,target);
            sum-=arr[i];
            path.removeLast();

        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates,0,target);
        return  result;
    }
    public static void main(String[] args){
        L39_250524_1 l392505241 = new L39_250524_1();
        for (List<Integer> integers : l392505241.combinationSum(new int[]{2, 3, 5}, 8)) {
            System.out.println(integers);
        }


    }
}
