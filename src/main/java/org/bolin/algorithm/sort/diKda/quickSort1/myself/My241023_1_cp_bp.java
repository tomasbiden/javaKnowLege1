package org.bolin.algorithm.sort.diKda.quickSort1.myself;

// 25-
// 1
public class My241023_1_cp_bp {
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

    public int findKthLargestByLR(int[] nums, int k,int l,int r) {
//        故意制造 stack out of flow
        findKthLargestByLR(nums,k,l,r);
        int len=nums.length;
        int partition = partition(nums, l, r);
//         len-1   1大          len-index  为 第   n 大
        if(len-partition==k){
            return partition;
        }

        if(k<partition){
            return  findKthLargestByLR(nums,k,partition+1,r);
        }else {
            return  findKthLargestByLR(nums,k,l,partition-1);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return  findKthLargestByLR(nums,k,0,nums.length-1);
    }

    public static void main(String[] args){
        int[] nums=new int[]{5,7,2,67,55,4,21,2,1};

        My241023_1_cp_bp my2410231 = new My241023_1_cp_bp();
        my2410231.findKthLargest(nums,3);



    }
}


/*
class Solution {
     public int findKthLargest(int[] nums, int k) {
        return quickselect(nums,0,nums.length-1,k);
    }

    public static int quickselect(int[] a, int l, int r,int k) {
        if (l >= r) {
            return a[l];
        }

        int i=partition(a,l,r);

        if((r-i+1)<k){
//              错误的，自认为从0开始
//            return  quickselect(nums,i+1,r,k-(i+1));
            return  quickselect(a,l,i-1,k-(r-i+1));
        }
        if((r-i+1)>k){
//            return quickselect(nums,l,i-1,k-(r-i+1));
            return quickselect(a,i+1,r,k);

        }
        return  a[i];

    }

    public static int  partition(int[] a, int l ,int r){
        int i=l;
        int j=r;
        int x=a[l];
//         注意这里是i < j 而不是 i<r
        while (i<j){
            while (i<j&&a[j]>x){
                j--;
            }
            if(i<j){
                a[i]=a[j];
                i++;
            }
            while (i<j&&a[i]<x){
                i++;
            }
            if(i<j){
//                这里是 j--而不是 j++
                a[j]=a[i];
                j--;
            }
        }
        a[i]=x;
        return i;

    }
}

 */
