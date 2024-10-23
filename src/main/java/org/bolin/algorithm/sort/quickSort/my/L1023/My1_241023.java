package org.bolin.algorithm.sort.quickSort.my.L1023;


//  1  3
//  18
public class My1_241023 {
    public  int partition(int[] nums,int l,int r){

        int priotValue=nums[l];
        while(l<r){
            while(l<r&&nums[r]>priotValue){
                r--;
            }
            if(l<r){
                nums[l++]=nums[r];
            }
            while (l<r&&nums[l]<priotValue){
                l++;
            }
            if(l<r){
                nums[r--]=nums[l];
            }
        }
        nums[l]=priotValue;
        return  l;
    }
    public  void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int partition = partition(nums, left, right);
        quickSort(nums,left,partition-1);
        quickSort(nums,partition+1,right);


    }

    public int[] sortArray(int[] nums) {
            quickSort(nums,0,nums.length-1);
            return nums;
    }
    public static void main(String[] args){
        int[] nums=new int[]{5,7,2,67,55,4,21,2,1};
        My1_241023 my1241023 = new My1_241023();

        int len=nums.length;
//        my1241023.partition(nums,0,len-1);
        my1241023.sortArray(nums);
        for (int num : nums) {
            System.out.print(num+" ");

        }

    }

}


/*
class Solution {
       public static void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void adjustHeam(int[] nums,int index,int length) {
//        这个len长度一定要放到函数值，因为后续堆排序时未排序的nums的大小事不断变化的啊
        if((index*2+1)>=length){
            return;
        }
//       int maxIndex=(index*2+2)>=index?index*2+1:Math.max(nums[index*2+1],nums[index*2+2]); 这里有问题的啊
//        (index*2+2)>=length?index*2+1:Math.max(nums[index*2+1],nums[index*2+2]); 这里还是有问题的啊
        int maxIndex=(index*2+2)>=length?index*2+1:(nums[index*2+2]>nums[index*2+1]?index*2+2:index*2+1);
        if(nums[index]<nums[maxIndex]){
            swap(nums,index,maxIndex);
            adjustHeam(nums,maxIndex,length);
        }





    }
    public   int[] sortArray(int[] nums){
        int len=nums.length;
//        (len-1/2) 这个括号是错误的啊
        for(int i=((len-1)/2);i>=0;i--){
            adjustHeam(nums,i,len);
        }

        System.out.println("最大堆化后" + Arrays.toString(nums));
        for(int i=len-1;i>=0;i--){
//            将大顶放到最后面
            swap(nums,i,0);
//            长度 -1
            adjustHeam(nums,0,i);
        }

        return  nums;

    }
}
 */
