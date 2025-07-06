package org.bolin.algorithm.matrix;

import java.util.ArrayList;
import java.util.List;

public class L59spiralOrder {
    private final int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int[][] generateMatrix(int n) {
        List<Integer> result=new ArrayList<>();
        int[][] matrix=new int[n][n];
        int cnt=0;
        int dirIndex=0;
        int tmpX=0;
        int tmpY=-1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){

                tmpX+=dir[dirIndex][0];
                tmpY+=dir[dirIndex][1];

                matrix[tmpX][tmpY]=++cnt;

                int nextX=tmpX+dir[dirIndex][0];
                int nextY=tmpY+dir[dirIndex][1];
                if(nextX<0||nextX>=matrix.length||nextY<0||nextY>=matrix[0].length||matrix[nextX][nextY]!=0){
                    dirIndex=(dirIndex+1)%4;
                }

            }
        }
        return matrix;

    }
}
