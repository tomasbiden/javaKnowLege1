package org.bolin.algorithm.backtracking.suiXiangLu.L46permute;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L46_250525_1 {
    public List<List<Integer>> result=new ArrayList<>();

    public LinkedList<Integer> path=new LinkedList<>();
//  2不能少了used[i]
    int[] used;

    public void backTracing(int[] arr){
        if(path.size()==arr.length){
            result.add(new ArrayList<>(path));
//           1: 不能少了这个 return 啊
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(used[i]==1){
                continue;
            }
            path.add(arr[i]);
//         4: used[arr[i]] 错误 uesd[i]
            used[i]=1;
            backTracing(arr);
            path.removeLast();
            used[i]=0;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
//        3:nums.length错误 nums.length+1
        used=new int[nums.length+1];
        backTracing(nums);
        return  result;
    }
    public static void main(String[] args){
        L46_250525_1 l462505251 = new L46_250525_1();
        for (List<Integer> integers : l462505251.permute(new int[]{1, 2, 3})) {
            System.out.println(integers);
        }


    }
}
