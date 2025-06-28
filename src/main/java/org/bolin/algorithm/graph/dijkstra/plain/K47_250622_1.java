package org.bolin.algorithm.graph.dijkstra.plain;

import java.util.Arrays;
import java.util.Scanner;

public class K47_250622_1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int e=scanner.nextInt();
        int[] minDist=new int[n+1];
//        1: minDist注意初始化
        Arrays.fill(minDist,Integer.MAX_VALUE);
        boolean[] visited=new boolean[n+1];
        minDist[1]=0;
        int[][] grapth=new int[n+1][n+1];
        for(int i=0;i<grapth.length;i++){
            Arrays.fill(grapth[i],Integer.MAX_VALUE);
        }

        for(int i=1;i<=e;i++){
            grapth[scanner.nextInt()][scanner.nextInt()]=scanner.nextInt();
        }
        for(int i=1;i<=n;i++){
//          3：-1注意会有空问题
            int cur=-1;
            int minValue=Integer.MAX_VALUE;
            for(int j=1;j<=n;j++){
                if(minValue>minDist[j]&&!visited[j]){
                    cur=j;
                    minValue=minDist[j];
                }
            }
            visited[cur]=true;

            for(int j=1;j<=n;j++){
//               2：这里注意数组越界问题，且必须可达才能遍历的啊
                if(!visited[j]&&grapth[cur][j]!=Integer.MAX_VALUE&&minDist[j]>minDist[cur]+grapth[cur][j]){
                    minDist[j]=minDist[cur]+grapth[cur][j];
                }
            }
        }
        System.out.println(minDist[n]==Integer.MAX_VALUE?-1:minDist[n]);


    }
}
