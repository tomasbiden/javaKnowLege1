package org.bolin.algorithm.binSearch;


class  L74searchMatrix_250706_1{


    public boolean searchMatrix(int[][] matrix, int target) {
        int left=0;int right=matrix.length*matrix[0].length;
        while (left<right){
            int mid=left+(right-left)/2;
            int num=matrix[mid/matrix[0].length][mid%matrix[0].length];
            if(num==target){
                return true;
            }
            if(num<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return false;
    }

}
public class L74searchMatrix {
}
