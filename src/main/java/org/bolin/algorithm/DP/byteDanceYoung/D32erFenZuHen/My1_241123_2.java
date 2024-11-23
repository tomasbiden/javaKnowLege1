package org.bolin.algorithm.DP.byteDanceYoung.D32erFenZuHen;

import java.util.logging.SocketHandler;

public class My1_241123_2 {
    public static int solution(int n, int A, int B, int[] array_a) {
        int[][] oldDp=new int[11][11];
        int[][] newDp=new int[11][11];

        int x=array_a[0]%10;
        oldDp[x][10]=1;
        oldDp[10][x]=1;
        for(int k=1;k<n;k++){

//            System.out.println("第" +k+"次");
//            System.out.println("  0 1 2 3 4 5 6 7 8 9 10");
            for(int i=0;i<11;i++){
//                System.out.print(i+" ");
                for(int j=0;j<11;j++){
                    //                    注意这个x要%10啊
                    x=array_a[k]%10;
                    int frontI=(i-x+10)%10;
                    int frontJ=(j-x+10)%10;
                    if(i==10&&j==10){
//                        System.out.print(newDp[i][j]+" ");
                        continue;
                    }
                    if(i==10){
                        newDp[i][j]=oldDp[i][frontJ];
//                        System.out.print(newDp[i][j]+" ");
                        continue;
                    }
                    if(j==10){
                        newDp[i][j]=oldDp[frontI][j];
//                        System.out.print(newDp[i][j]+" ");
                        continue;
                    }



                    int value1=oldDp[frontI][j];
                    int value2=oldDp[i][frontJ];
//                    int value3=oldDp[frontI][10]+oldDp[10][frontJ];
                    int value3=0;
                    if(i==x){
                        value3+=oldDp[10][j];
                    }
                    if(j==x){
                        value3+=oldDp[i][10];
                    }
                    newDp[i][j]=value1+value2+value3;

//                    System.out.print(newDp[i][j]+" ");
                }
//                System.out.println();

            }





            oldDp=newDp;
            newDp=new int[11][11];

        }
        if(A>B){
            int tmp=A;
            A=B;
            B=tmp;
        }
//        注意有特色情况的啊

        return  oldDp[A][B]+oldDp[A][10]+oldDp[B][10];
     }

    public static void main(String[] args) {
        //  You can add more test cases here
        int[] array1 = {1, 1, 1};
        int[] array2 = {1, 1, 1};
        int[] array3 = {1, 1};
//        System.out.println(solution(3, 1, 2, array1) );
//        System.out.println(solution(3, 3, 5, array2) );
//        System.out.println(solution(2, 1, 1, array3) );
        System.out.println(solution(3, 1, 2, array1) == 3);
        System.out.println(solution(3, 3, 5, array2) == 1);
        System.out.println(solution(2, 1, 1, array3) == 2);
    }
}
