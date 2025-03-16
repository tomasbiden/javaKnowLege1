package org.bolin.algorithm.Array.group1.dir1;

import java.util.Scanner;

// class注意是没有()的啊
public class K58QuJianHe {

    public void quJianHe_QianZuiHe(){
        Scanner scanner = new Scanner(System.in);
        int n=0;
        n=scanner.nextInt();
        int [] arr=new int[n];
        int[] sumArr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
            if(i!=0){
                sumArr[i]+=sumArr[i-1]+arr[i];
            }else {
                sumArr[i]=arr[i];
            }

        }
        while (scanner.hasNextInt()){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
//            System.out.println(sumArr[b]-sumArr[a-1]);  这里 a-1未进行空判断
            if(a==0){
                System.out.println(sumArr[b]);
            }else {
                System.out.println(sumArr[b]-sumArr[a-1]);
            }
        }

    }
}
