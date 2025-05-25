package org.bolin.algorithm.backtracking.suiXiangLu.L90subsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L90_250525_1 {

    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public void backTracking(int[] arr,int startIndex){
        result.add(new ArrayList<>(path));

        for(int i=startIndex;i<arr.length;i++){
            if(i!=startIndex&&arr[i]==arr[i-1]){
                continue;
            }
            path.add(arr[i]);
            backTracking(arr,i+1);
            path.removeLast();
        }
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums,0);
        return result;
    }
}
