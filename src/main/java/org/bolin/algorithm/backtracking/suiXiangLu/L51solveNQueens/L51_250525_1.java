package org.bolin.algorithm.backtracking.suiXiangLu.L51solveNQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L51_250525_1 {

    List<List<String>> result=new ArrayList<>();

    char[][] chessBorad;
     private boolean checkValid(int row,int col,int n){
         for(int i=row-1;i>=0;i--){
             if(chessBorad[i][col]=='Q'){
                 return false;
             }
         }
         for(int i=row-1,j=col-1;(i>=0&&j>=0);i--,j--){
             if(chessBorad[i][j]=='Q'){
                 return false;
             }
         }
         for(int i=row-1,j=col+1;(i>=0&&j<n);i--,j++){
             if(chessBorad[i][j]=='Q'){
                 return  false;
             }
         }
         return true;

     }
     public List<String> chessBoard2List(char[][] chessBorad){
         ArrayList<String> path = new ArrayList<>();
         for (char[] chars : chessBorad) {
             path.add(String.valueOf(chars));
         }
         return path;
     }

     public void backTracing(int row,int n){
         if(row==n){
             result.add(chessBoard2List(chessBorad));
         }
         for(int col=0;col<n;col++){
             if(checkValid(row,col,n)){
                 chessBorad[row][col]='Q';
                 backTracing(row+1,n);
                 chessBorad[row][col]='.';

             }
         }
         return;
     }
    public List<List<String>> solveNQueens(int n) {
         chessBorad=new char[n][n];
        for (char[] chars : chessBorad) {
            Arrays.fill(chars,'.');
        }
        backTracing(0,n);
        return  result;

    }
    public static void main(String[] args){
        L51_250525_1 l512505251 = new L51_250525_1();
        for (List<String> solveNQueen : l512505251.solveNQueens(4)) {
            System.out.println(solveNQueen);
        }


    }
}
