package org.bolin.algorithm.realQuestion.jingDong.jd0814.K261;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class K261_250622_3 {
//  没有考虑到可以 一个 i对多个j的情况啊
    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.split(" ");
        int n=Integer.parseInt(s1[0]);
        int k=Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        int[] arr=new int[n];

        Map<Integer,Integer> numCntMap=new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(s2[i]);
            numCntMap.put(arr[i],numCntMap.getOrDefault(arr[i],0)+1);
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
