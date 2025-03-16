package org.bolin.algorithm.Array.group1.dir1;

public class L977sortedSquares {

    public int abs(int x){
        if(x<0){
            return  x*(-1);
        }else {
            return x;
        }

    }

    public int[] sortedSquares_250316_doublePointer_1(int[] nums) {
        int k=nums.length-1;
//        注意i<=j 这里有个;
        int[] result=new int[nums.length];
        for(int i=0,j=nums.length-1;i<=j;){
            if(abs(nums[j])>abs(nums[i])){
//                nums[k--]=nums[j]*nums[j];
//                注意是result而不是别的了啊
                result[k--]=nums[j]*nums[j];
                j--;
            }else {
//                nums[k--]=nums[i]*nums[i];
                result[k--]=nums[i]*nums[i];
                i++;
            }
        }
        return  result;

    }


}
