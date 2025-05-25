package org.bolin.algorithm.backtracking.suiXiangLu.L40combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L40_250524_1 {
    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    int sum=0;
    public void backTracking(int[] arr,int startIndex,int target){
        if(sum==target){
            result.add(new ArrayList<>(path));
        }
        for(int i=startIndex;i<arr.length&&sum<target;i++){
            if(i!=startIndex&&arr[i]==arr[i-1]){

                    continue;
            }
            path.add(arr[i]);
            sum+=arr[i];
            backTracking(arr,i+1,target);
            sum-=arr[i];
            path.removeLast();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates,0,target);
        return result;
    }
    public static void main(String[] args){
        L40_250524_1 l40combinationSum22505191 = new L40_250524_1();
        for (List<Integer> integers : l40combinationSum22505191.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)) {
            System.out.println(integers);
        }


    }
}
