package org.bolin.algorithm.graph.kama;

import java.util.Scanner;

public class K101_250613_102 {
//    这里有个严重问题，你怎么能改动原来传递过来的参数呢

    private static int count=0;

    private static boolean isCrical=false;

    private static int lonelyAreaSize=0;
    static int tmpSize=0;
    static int maxSize=0;
    static  int allSize=0;
    static int[][] dir=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

//    int n,int m 可以用 grapth
    public static void dfs(int x,int y,int[][] graph){
        graph[x][y]=2;
        if((x==0||x==(graph.length-1))||(y==0||y==(graph[0].length-1))){
            isCrical=true;
        }
        tmpSize++;
        for(int i=0;i<4;i++){
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if(checkDirValid(graph,nx,ny)){

                dfs(nx,ny,graph);
            }


        }
    }
    public static boolean checkDirValid(int[][] graph,int nx,int ny){
        if((nx<0||nx>=graph.length)||(ny<0||ny>=graph[0].length)||graph[nx][ny]!=1){
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
        for(int j=0;j<m;j++){
            if(grapth[0][j]==1){
                dfs(0,j,grapth);
            }
            if(grapth[n-1][j]==1){
                dfs(n-1,j,grapth);
            }
        }

        for(int i=0;i<n;i++){
            if(grapth[i][0]==1){
                dfs(i,0,grapth);
            }
            if(grapth[i][m-1]==1){
                dfs(i,m-1,grapth);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
//                这个顺序不能变的啊
                if(grapth[i][j]==1) grapth[i][j]=0;
                if(grapth[i][j]==2) grapth[i][j]=1;

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(grapth[i][j]+" ");
            }
            System.out.println();
        }
//     这里非常关键的啊
        scanner.close();



    }
}
