package org.bolin.algorithm.graph.Leecode.L200numIslands.myself;

import java.util.Scanner;

public class My1_241024_CP {
    //      6
    boolean[][] used;
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void dfs(char[][] grid, int x, int y, int xLen, int yLen) {
        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
//            越界判断的要先放到前面的啊  ， 是 nx 而不少 x啊        used[nx][ny] 错误
            if (nx >= xLen || nx < 0 || ny >= yLen || ny < 0 || grid[nx][ny] == '0' || used[nx][ny]) {

            } else {
                used[nx][ny] = true;
                dfs(grid, nx, ny, xLen, yLen);
            }
        }


    }

    public int numIslands(char[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        int num = 0;
        used = new boolean[xLen][yLen];

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
//  等于 0是海洋才对的啊   注意 char 与 int的区别啊
                if (used[i][j] || grid[i][j] =='0' ) {

                } else {
                    num++;
                    used[i][j] = true;
                    dfs(grid, i, j, xLen, yLen);
                }
            }
        }
        return num;

    }

    public static void main(String[] args) {
        char[][] chars = {
                {'1', '1', '1', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        My1_241024_CP my1241024 = new My1_241024_CP();

        Scanner sc=new Scanner(System.in);
//        int  x=sc.nextInt();
//        int y=sc.nextInt();
//        char[][] chars2=new char[x][y];

       String str1=sc.nextLine();
       String str2=sc.nextLine();

    }
}
