package org.bolin.algorithm.matrix;
class L48rotate_250705_1{
    public void rotate(int[][] matrix) {

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }

        for(int[] arr: matrix){
            for(int i=0;i<arr.length/2;i++){
                int tmp=arr[i];
                arr[i]=arr[arr.length-1-i];
                arr[arr.length-1-i]=tmp;

            }
        }
    }
}
public class L48rotate {
}
