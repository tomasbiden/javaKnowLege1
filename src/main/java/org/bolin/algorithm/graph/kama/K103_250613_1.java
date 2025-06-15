package org.bolin.algorithm.graph.kama;

import java.util.Scanner;

public class K103_250613_1 {
//    这里有个严重问题，你怎么能改动原来传递过来的参数呢

    private static int count=0;

    private static boolean isCrical=false;

    private static int lonelyAreaSize=0;
    static int tmpSize=0;
    static int maxSize=0;
    static  int allSize=0;
    static int[][] dir=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

//    int n,int m 可以用 graph
    public static void dfs(int x,int y,int[][] graph,boolean[][] visited){
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if(checkDirValid(x,y,graph,nx,ny,visited)){
                dfs(nx,ny,graph,visited);
            }


        }
    }
    public static boolean checkDirValid(int x,int y,int[][] graph,int nx,int ny,boolean[][] visited){
//       (visited[nx][ny]) 加入，防止死循环
        if((nx<0||nx>=graph.length)||(ny<0||ny>=graph[0].length)||(visited[nx][ny])||(graph[x][y]>graph[nx][ny])){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] graph=new int[n][m];
        boolean[][] leftTopArea=new boolean[n][m];
        boolean[][] rightBottom=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                graph[i][j]=scanner.nextInt();
            }
        }
        int[][] visited=new int[n][m];
        for(int j=0;j<m;j++){
                dfs(0,j,graph,leftTopArea);
                dfs(n-1,j,graph,rightBottom);

        }

        for(int i=0;i<n;i++){
                dfs(i,0,graph,leftTopArea);
                dfs(i,m-1,graph,rightBottom);

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(leftTopArea[i][j]&&rightBottom[i][j]){
                    System.out.println(i+" "+j);
                }

            }
        }
//     这里非常关键的啊
        scanner.close();



    }
}
