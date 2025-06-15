package org.bolin.algorithm.graph.kama;

import java.util.Scanner;

public class K99_250612_1 {
//    这里有个严重问题，你怎么能改动原来传递过来的参数呢

    private static int count=0;



    static int[][] dir=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

//    int n,int m 可以用 grapth
    public static void dfs(int x,int y,int[][] grapth,int n,int m,int[][] visited){
        for(int i=0;i<4;i++){
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if(checkDirValid(grapth,visited,nx,ny,n,m)){
                visited[nx][ny]=1;
                dfs(nx,ny,grapth,n,m,visited);
            }

        }
    }
    public static boolean checkDirValid(int[][] graph,int[][] visited,int nx,int ny,int n,int m){
        if((nx<0||nx>=n)||(ny<0||ny>=m)||(visited[nx][ny]==1)||graph[nx][ny]==0){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] grapth=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grapth[i][j]=scanner.nextInt();
            }
        }
        int[][] visited=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]!=1&&grapth[i][j]==1){
                    visited[i][j]=1;
                    dfs(i,j,grapth,n,m,visited);
                    count++;
                }
            }
        }
        System.out.println();



    }
}
