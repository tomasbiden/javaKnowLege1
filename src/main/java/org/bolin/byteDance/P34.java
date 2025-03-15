package org.bolin.byteDance;

import java.util.*;

public class P34 {

    public static int solution(int n, int[] nums) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        List<Integer> list =new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(nums[i]);
        }



        Set<Integer> set = new HashSet<>(list);


        List<Integer> sortedList = new ArrayList<>(set);
        n=sortedList.size();
        Collections.sort(sortedList);
        if(n<=2){
            return  sortedList.get(n-1);
        }else {
            return   sortedList.get(n-3);
        }

    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[] { 3, 2, 1 }) == 1);
        System.out.println(solution(2, new int[] { 1, 2 }) == 2);
        System.out.println(solution(4, new int[] { 2, 2, 3, 1 }) == 1);
    }
}
