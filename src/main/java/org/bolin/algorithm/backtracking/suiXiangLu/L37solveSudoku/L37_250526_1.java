package org.bolin.algorithm.backtracking.suiXiangLu.L37solveSudoku;

public class L37_250526_1 {

    private boolean checkValie(int row,int col,int num,char[][] board){
        for(int i=0;i<board.length;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        for(int j=0;j<board.length;j++){
            if(board[row][j]==num){
                return false;
            }
        }
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for(int i=startRow;i<=startRow+2;i++){
            for(int j=startCol;j<=startCol+2;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return  true;
    }
    public boolean backTracking(int row,int col,char[][] board){
//       1: 不是10啊
        if(row==9){
         return true;
        }
//       2:要有等于号啊
        int nextRow=col+1>=9?row+1:row;
        int nextCol=col+1>=9?0:col+1;
        if(board[row][col]!='.'){
            return backTracking(nextRow,nextCol,board);
        }
//       3:i 从int改为char
        for(char i='1';i<='9';i++){
            if(checkValie(row,col,i,board)){
                board[row][col]=i;
                if(backTracking(nextRow,nextCol,board)) return true;
                board[row][col]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        backTracking(0,0,board);
    }
    public static void main(String[] args){
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        L37_250526_1 l372505261 = new L37_250526_1();
        l372505261.solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(chars);
        }

    }
}
