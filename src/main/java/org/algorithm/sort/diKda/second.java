package org.algorithm.sort.diKda;

//这个代码可以是可以，但是运行很慢
public class second {
    public  static  void swap(int[] nums,int i,int j){
        int tmpValue=nums[i];
        nums[i]=nums[j];
        nums[j]=tmpValue;

    }
    public static int quickselect(int[] nums,int l,int r,int k){
        if(l>=r){
            return  nums[l];
        }
        int i=l;
        int j=r;
        int priot=nums[i];
        while (i<j){
            while (i<j&&nums[i]<=priot){
                i++;
            }
//            让相等的数字尽量放到左边去
            while (i<j&&nums[j]>priot){
                j--;
            }


            if(i<j){
                swap(nums,i,j);
            }
        }
        swap(nums,l,i);
        if((r-i+1)<k){
//              错误的，自认为从0开始
//            return  quickselect(nums,i+1,r,k-(i+1));
            return  quickselect(nums,l,i-1,k-(r-i+1));
        }
        if((r-i+1)>k){
//            return quickselect(nums,l,i-1,k-(r-i+1));
            return quickselect(nums,i+1,r,k);

        }
        return  nums[i];

    }
    public int findKthLargest(int[] nums, int k) {
        int   result= quickselect(nums, 0, nums.length - 1,k);
        return result;
    }
}
