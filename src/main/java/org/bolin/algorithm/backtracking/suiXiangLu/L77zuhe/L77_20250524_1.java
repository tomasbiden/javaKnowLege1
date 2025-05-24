package org.bolin.algorithm.backtracking.suiXiangLu.L77zuhe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L77_20250524_1 {
    List<List<Integer>> result=new ArrayList<>();

    List<Integer> path=new LinkedList<>();
    public void backTracking(int[] arr,int startIndex,int k){
            if(path.size()==k){
                result.add(new ArrayList<>(path));
                return;
            }
//            4-startIndex错误 应该为-i
            for(int i=startIndex;path.size()+arr.length-i>=k;i++){
//                2：arr[startIndex]错误
                path.add(arr[i]);
//               3startIndex+1 错误应该为 i+1
                backTracking(arr,i+1,k);
                path.remove(path.size()-1);
            }
    }
    public List<List<Integer>> combine(int n, int k) {
        int[] arr=new int[n];
//        1:等于n 错误
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        backTracking(arr,0,k);

        return result;

    }
    public static void main(String[] args){
        L77_20250524_1 l77202505241 = new L77_20250524_1();
        List<List<Integer>> combine = l77202505241.combine(3, 2);
        combine.forEach(path-> System.out.println(path));

    }
}
