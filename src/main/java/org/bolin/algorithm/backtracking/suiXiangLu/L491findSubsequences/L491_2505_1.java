package org.bolin.algorithm.backtracking.suiXiangLu.L491findSubsequences;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L491_2505_1 {
    public List<List<Integer>> result=new ArrayList<>();

    public LinkedList<Integer> path=new LinkedList<>();

    public void backTracking(int[] arr,int startIndex){
        if(path.size()>1){
            result.add(new ArrayList<>(path));
        }
        int[] used=new int[201];
        for(int i=startIndex;i<arr.length;i++){
            if((!path.isEmpty()&&path.getLast()>arr[i])||used[arr[i]+100]==1){
                    continue;
            }
//            这句不能漏掉了啊
            used[arr[i]+100]=1;
            path.add(arr[i]);
            backTracking(arr,i+1);
            path.removeLast();
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return result;
    }
    public static void main(String[] args){
        L491_2505_1 l49125051 = new L491_2505_1();
        for (List<Integer> subsequence : l49125051.findSubsequences(new int[]{4, 6, 7, 7})) {
            System.out.println(subsequence);
        }


    }

}
