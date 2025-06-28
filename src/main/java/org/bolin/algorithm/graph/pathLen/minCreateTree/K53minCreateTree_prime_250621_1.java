package org.bolin.algorithm.graph.pathLen.minCreateTree;

import java.util.Arrays;
import java.util.Scanner;

public class K53minCreateTree_prime_250621_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int vSize=scanner.nextInt();
        int eSize=scanner.nextInt();
//        注意初始化赋最大值的啊
        int [][] grid=new int[vSize+1][vSize+1];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(grid[i],10001);
        }

        for(int i=1;i<=eSize;i++){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            int z=scanner.nextInt();
            grid[x][y]=z;
//           注意是无向图啊
            grid[y][x]=z;
        }
        boolean[] isInTree=new boolean[vSize+1];
        int [] minDist=new int[vSize+1];
        Arrays.fill(minDist,10001);
        for(int i=1;i<vSize;i++){
//       注意是max啊
            int minLen=Integer.MAX_VALUE;
            int cur=-1;
            for(int j=1;j<=vSize;j++){
                if(!isInTree[j]&&minLen>minDist[j]){
                    cur=j;
                    minLen=minDist[j];
                }
            }
            isInTree[cur]=true;

            for(int k=1;k<=vSize;k++){
                if(!isInTree[k]&&minDist[k]>grid[cur][k]){
                    minDist[k]=grid[cur][k];
                }
            }

        }
        int result=0;
        for(int i=2;i<=vSize;i++){
            result+=minDist[i];
        }
        System.out.println(result);
        scanner.close();
    }

}
