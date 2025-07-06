package org.bolin.algorithm.matrix;
class  L73setZeroes_250704_1{
    public void setZeroes(int[][] matrix) {

        boolean row0=false;
        boolean column0=false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                column0=true;
            }
        }
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                row0=true;
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            if(column0){
                matrix[i][0]=0;
            }
        }
//     1:matrix.length 错误
        for(int j=0;j<matrix[0].length;j++){
            if(row0){
                matrix[0][j]=0;
            }
        }
    }
}
public class L73setZeroes {
}
