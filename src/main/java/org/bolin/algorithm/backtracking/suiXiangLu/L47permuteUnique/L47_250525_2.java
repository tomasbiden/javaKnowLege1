package org.bolin.algorithm.backtracking.suiXiangLu.L47permuteUnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L47_250525_2 {
    public List<List<Integer>> result=new ArrayList<>();

    public LinkedList<Integer> path=new LinkedList<>();

    int[] used;

    public void backTracing(int[] arr){
        if(path.size()==arr.length){
            result.add(new ArrayList<>(path));

            return;
        }

        for(int i=0;i<arr.length;i++){

            if(used[i]==1||(i>0&&arr[i]==arr[i-1]&&used[i-1]==0)){
                int h=1;
                continue;
            }
            path.add(arr[i]);
            used[i]=1;
            backTracing(arr);
            path.removeLast();
            used[i]=0;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        used=new int[nums.length+1];
        backTracing(nums);
        return  result;
    }
    public static void main(String[] args){
        L47_250525_2 l472505251 = new L47_250525_2();
        for (List<Integer> integers : l472505251.permuteUnique(new int[]{1, 1, 2})) {
            System.out.println(integers);
        }


    }
}
