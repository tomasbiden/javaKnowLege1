package org.bolin.algorithm.graph.kama;

import java.util.Scanner;

public class K105_250614_1 {

    static int visitedNum=0;

    public static void dfs(int startNode,int[][] graph,boolean[] visited){
        visitedNum++;
//        放到这里就不会有初始化的问题了啊
        visited[startNode]=true;
        for(int i=0;i<graph.length;i++){
            if(graph[startNode][i]==1&&!visited[i]){
//                visited[i]=true;
                dfs(i,graph,visited);
            }
        }

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int[][] graph=new int[n+1][n+1];

        for(int i=0;i<k;i++){
            graph[scanner.nextInt()][scanner.nextInt()]=1;
        }
        boolean[] visited=new boolean[n+1];
        dfs(1,graph,visited);
        if(visitedNum==n){
            System.out.println(1);
        }else {
            System.out.println(-1);
        }

    }

}
