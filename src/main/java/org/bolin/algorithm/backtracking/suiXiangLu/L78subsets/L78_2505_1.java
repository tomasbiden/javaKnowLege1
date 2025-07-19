package org.bolin.algorithm.backtracking.suiXiangLu.L78subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class L78_subsets{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> paht=new ArrayList<>();
        dfs(nums,0,result,paht);
        return result;
    }
    public void dfs(int[] nums,int startIndex,List<List<Integer>> result,List<Integer> path){
        result.add(new ArrayList<>(path));
        if(startIndex>=nums.length){
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            dfs(nums,i+1,result,path);
            path.remove(path.size()-1);
        }
    }
}
public class L78_2505_1 {
    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public void backTracking(int[] arr,int startIndex){
        result.add(new ArrayList<>(path));

        for(int i=startIndex;i<arr.length;i++){
            path.add(arr[i]);
            backTracking(arr,i+1);
            path.removeLast();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums,0);
        return result;
    }
    public static void main(String[] args){
        L78_2505_1 l7825051 = new L78_2505_1();
        for (List<Integer> subset : l7825051.subsets(new int[]{1, 2, 3})) {
            System.out.println(subset);
        }


    }
}
