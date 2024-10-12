package org.algorithm.Array.niukehot100;

import java.util.HashMap;

public class BM92 {
    public int maxLength (int[] arr) {
        if(arr.length==0){
            return 0;
        }
        if(arr.length==1){
            return 1;
        }
        int i=0; int j=1;
        int len=arr.length;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(arr[0],0);
        int max=0;
        while(i<arr.length&&j<arr.length){
            if(hashMap.containsKey(arr[j])){
                int result=j-i;
                max=Math.max(max,result);
                i=Math.max(i,hashMap.get(arr[j])+1);
                hashMap.put(arr[j],j);
//                j=i+1;
                j++;

            }else {
                hashMap.put(arr[j],j);
                j++;
            }


        }
        int result=j-i-1;
        max=Math.max(max,result);

        return  max;
        // write code here
    }
}
