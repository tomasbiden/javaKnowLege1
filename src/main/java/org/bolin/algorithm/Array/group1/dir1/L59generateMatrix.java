package org.bolin.algorithm.Array.group1.dir1;

public class L59generateMatrix {

    public int[][] generateMatrix_250316_offset_1(int n) {
        int [][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int [][] result=new int[n][n];
        int count=0;
        int startX=0;
        int startY=0;
        int offset=1;
        for(int loop=1;loop<=n/2;loop++){
            for(int dirTmp=0;dirTmp<dir.length;dirTmp++){
                for(int walkCount=1;walkCount<=n-offset;walkCount++){
                    result[startX][startY]=++count;
                    startX+=dir[dirTmp][0];
                    startY+=dir[dirTmp][1];
                }
            }
//            注意调整方向，进入下一层的模拟啊， 然后走的次数是以2为次数递减的啊
            startX++;
            startY++;
            offset+=2;

        }
        if(n%2==1){
//            result[startX][startY]=++count;
            result[n/2][n/2]=++count;
        }
        return  result;
    }
    public static void main(String[] args){
        L59generateMatrix l59generateMatrix = new L59generateMatrix();
        l59generateMatrix.generateMatrix_250316_offset_1(4);

    }

}
