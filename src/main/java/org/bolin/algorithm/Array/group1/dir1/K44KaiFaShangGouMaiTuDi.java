package org.bolin.algorithm.Array.group1.dir1;

import java.util.Scanner;

public class K44KaiFaShangGouMaiTuDi {

    public  static int k44_0322_qianZuiHe_1(){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[]  horizontal= new int[n];
        int[]  vertical=new int[m];
        int allSum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int value = scanner.nextInt();
                horizontal[i]+=value;
                vertical[j]+=value;
                allSum+=value;
            }
        }
        int result=Integer.MAX_VALUE;
        int horizontalSum=0;
        int verticalSum=0;
        for(int i=0;i<n;i++){
            horizontalSum+=horizontal[i];
            result=Math.min(result,Math.abs(allSum-2*horizontalSum));
        }
        for(int j=0;j<m;j++){
            verticalSum+=vertical[j];
            result=Math.min(result,Math.abs(allSum-2*verticalSum));

        }
        return result;



    }
    public static void main(String[] args){
        System.out.println(k44_0322_qianZuiHe_1());
    }
}
