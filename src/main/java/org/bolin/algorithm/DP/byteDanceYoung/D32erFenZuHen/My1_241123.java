package org.bolin.algorithm.DP.byteDanceYoung.D32erFenZuHen;

public class My1_241123 {
    public static int solution(int n, int A, int B, int[] array_a) {
        int[][] oldDp=new int[10][10];
        int[][] newDp=new int[10][10];
        oldDp[0][0]=1;
        for(int k=0;k<n;k++){
            for(int i=0;i<10;i++){
                for(int j=0;j<10;j++){
//                    注意这个x要%10啊
                    int x=array_a[k]%10;
                    int frontI=(i-x+10)%10;
                    int frontJ=(j-x+10)%10;

                    int value1=oldDp[frontI][j];
                    int value2=oldDp[i][frontJ];
                    newDp[i][j]=value1+value2;
                    System.out.print(value1+value2+" ");
                }
                System.out.println();
            }
            System.out.println("结束了");

            oldDp=newDp;
            newDp=new int[10][10];

        }
        if(A>B){
            int tmp=A;
            A=B;
            B=tmp;
        }
//        注意有特色情况的啊

        return  oldDp[A][B]+oldDp[A][0]+oldDp[B][0];
     }

    public static void main(String[] args) {
        //  You can add more test cases here
        int[] array1 = {21,9,16,7,9,19,8,4,1,17,1,10,16};
        int[] array2 = {1, 1, 1};
        int[] array3 = {1, 1};

        System.out.println(solution(array1.length, 8, 3, array1) );
//        System.out.println(solution(3, 3, 5, array2) == 1);
//        System.out.println(solution(2, 1, 1, array3) == 2);
    }
}
