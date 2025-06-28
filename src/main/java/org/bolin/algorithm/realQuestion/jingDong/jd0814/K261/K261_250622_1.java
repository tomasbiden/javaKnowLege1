package org.bolin.algorithm.realQuestion.jingDong.jd0814.K261;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class K261_250622_1 {
//  没有考虑到可以 一个 i对多个j的情况啊
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int[] arr=new int[n];
        Set<Integer> set=new HashSet<>();

        for(int i=0;i<n;i++){
            int x=scanner.nextInt();
            arr[i]=x;
            set.add(x);
        }
        int result=0;
        for(int i=0;i<n;i++){
            int x=arr[i];
            if(set.contains(k-x)){
                result++;
            }
        }
        System.out.println(result);

    }
}
