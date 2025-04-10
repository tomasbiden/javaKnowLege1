package org.bolin.algorithm.lanqiao.th15.sheng.shiTang;

import java.util.Scanner;

public class Main {
   public static int sum=0;
    public  static  void function1(int[] arr){


        for(int i=1;i<=arr[4];i++){

            if(arr[1]>=2){
                arr[1]-=2;
                sum+=6;
                continue;
            }
            if(arr[0]>=1&&arr[2]>=1){
                sum+=6;
                arr[0]--;
                arr[2]--;
                continue;
            }
            if(arr[0]>=3){
                arr[0]-=3;
                sum+=6;
                continue;
            }
            if(arr[0]>=1&&arr[1]>=1){
                arr[0]--;
                arr[1]--;
                sum+=5;
                continue;
            }
            if(arr[2]>=1){
                sum+=4;
                arr[2]--;
                continue;
            }
            if(arr[0]>=2){
                sum+=4;
                arr[0]-=2;
                continue;
            }
            if(arr[1]>=1){
                sum+=3;
                arr[1]--;
                continue;
            }
            if(arr[0]>=1){
                sum+=2;
                arr[0]--;
                continue;

            }else {
                break;
            }
        }
        int a2=arr[0];
        int a3=arr[1];
        int a4=arr[2];

        int b4=arr[3];
        int b6=arr[4];
        for(int i=1;i<=arr[3];i++){
            if(arr[2]>=1){
                sum+=4;
                arr[2]--;
                continue;
            }
            if(arr[0]>=2){
                sum+=4;
                arr[0]-=2;
                continue;
            }
            if(arr[1]>=1){
                sum+=3;
                arr[1]--;
                continue;

            }
            if(arr[0]>=1){
                sum+=2;
                arr[0]--;
                continue;
            }else {
                break;
            }
        }


    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=1;i<=n;i++){
           int[] arr=new int[5];
            sum=0;
           for(int j=0;j<5;j++){
               arr[j]=scanner.nextInt();
           }
            function1(arr);
            System.out.println(sum);
        }

    }
}
