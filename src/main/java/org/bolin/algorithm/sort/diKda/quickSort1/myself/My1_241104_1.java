package org.bolin.algorithm.sort.diKda.quickSort1.myself;

import java.util.Random;

public class My1_241104_1 {

//    40
//
    Random random=new Random();
    public void swap(int[] nums,int indexA,int indexB){
        int tmp=nums[indexA];
        nums[indexA]=nums[indexB];
        nums[indexB]=tmp;
    }
    public int partition(int [] nums,int left,int right){
//        头包尾不包
        int randomIndex= random.nextInt(right-left+1)+left;
        swap(nums,left,randomIndex);
        int priotValue=nums[left];
        int i=left;
        int j=right;
        while (i<j){
            while (i<j&&nums[j]>priotValue){
                j--;
            }
            if(i<j){
                nums[i++]=nums[j];
            }
            while (i<j&&nums[i]<priotValue){
                i++;
            }
            if(i<j){
                nums[j--]=nums[i];
            }

        }

        nums[i]=priotValue;
        return i;
    }

    public int findKthLargestByDiGui(int[] nums, int left,int right,int k) {
        int len=nums.length;
        int partition = partition(nums, left, right);
        int diNDa=len-partition;
        if(diNDa==k){
//            注意返回的是索引还是值啊
            return nums[partition];
        }
//
        if(diNDa>k){
//            注意这里一定是left,right，而不是 0 ，len-1
            return  findKthLargestByDiGui(nums,partition+1,right,k);
        }
        if(diNDa<k){
            return  findKthLargestByDiGui(nums,left,partition-1,k);
        }
        return 0;

    }
    public int findKthLargest(int[] nums, int k) {

        return findKthLargestByDiGui(nums,0,nums.length-1,k);

    }
    public static void main(String[] args){
        int[] nums=new int[]{3,2,3,1,2,4,5,5,6};
        My1_241104_1 my12411041 = new My1_241104_1();
        my12411041.findKthLargest(nums,9);

    }
}
