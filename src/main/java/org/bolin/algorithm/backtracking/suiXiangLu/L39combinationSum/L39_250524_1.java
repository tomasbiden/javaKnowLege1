package org.bolin.algorithm.backtracking.suiXiangLu.L39combinationSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class L39_250629_1{
    int sum=0;
    List<Integer> path=new ArrayList<>();
    List<List<Integer>> result=new ArrayList<>();

    public void traversal(int startIndex,int[] candidates,int target){
        if(sum>target){
            return;
        }
        if(sum==target){
            result.add(new ArrayList<>(path));
        }

        for(int i=startIndex;i<candidates.length;i++){
            sum+=candidates[i];
            path.add(candidates[i]);
            traversal(i,candidates,target);
            sum-=candidates[i];
            path.remove(path.size()-1);
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        traversal(0,candidates,7);
//        System.out.println(result);
        return result;
    }
    public static void main(String[] args){
        L39_250629_1 l392506291 = new L39_250629_1();
        List<List<Integer>> lists = l392506291.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }
}








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
