package org.bolin.algorithm.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int x;
    int y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class L994_0624_1 {
    int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue=new LinkedList<Pair>();
        int[][] visited=new int[grid.length][grid[0].length];
        int freshOriginSize=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new Pair(i,j));
                    visited[i][j]=1;
                }
                if(grid[i][j]==1){
                    freshOriginSize++;
                }
            }
        }
        int minute=0;
//       2:有新鲜果才进行bfs
        while (!queue.isEmpty()&&freshOriginSize>0){
            int len=queue.size();
            for(int i=0;i<len;i++){
                Pair poll = queue.poll();
                for(int j=0;j<dir.length;j++){
                    int nx=poll.x+dir[j][0];
                    int ny=poll.y+dir[j][1];

                    if((nx>=0&&nx<grid.length)&&(ny>=0&&ny<grid[0].length)&&visited[nx][ny]!=1&&grid[nx][ny]==1){
                        freshOriginSize--;
//                        这里不能漏洞了啊
                        visited[nx][ny]=1;
                        queue.offer(new Pair(nx,ny));
                    }
                }

            }
            minute++;
        }
//       新鲜果为0，则为minutes 否则为 -1
        return freshOriginSize==0?minute:-1;


    }
}
