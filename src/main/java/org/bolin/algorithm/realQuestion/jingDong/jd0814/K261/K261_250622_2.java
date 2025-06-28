package org.bolin.algorithm.realQuestion.jingDong.jd0814.K261;

import java.util.*;

public class K261_250622_2 {
//  没有考虑到可以 一个 i对多个j的情况啊
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int[] arr=new int[n];
        Map<Integer,Integer> numCntMap=new HashMap<>();

        for(int i=0;i<n;i++){
            int x=scanner.nextInt();
            arr[i]=x;
            numCntMap.put(x,numCntMap.getOrDefault(x,0)+1);

        }
        int result=0;
        for(int i=0;i<n;i++){
            int x=arr[i];
            result+=numCntMap.getOrDefault(k-x,0
            );
        }
        System.out.println(result);

    }
}
