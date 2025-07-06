package org.bolin.algorithm.matrix;


import java.util.ArrayList;
import java.util.List;

class L54spiralOrder_250705_1{
    private final  int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> reslut=new ArrayList<>();
//           m,n的顺序不要搞反了啊
            int m=matrix.length;
            int n=matrix[0].length;
            int tmpX=0;
            int tmpY=-1;
            for(int di=0;reslut.size()<matrix.length*matrix[0].length;di=(di+1)%4){
                for(int k=0;k<n;k++){
                    tmpX+=dir[di][0];
                    tmpY+=dir[di][1];
                    reslut.add(matrix[tmpX][tmpY]);
                }

                int tmp=n;
                n=m-1;
                m=tmp;

            }
            return reslut;

    }
}
public class L54spiralOrder {
}
