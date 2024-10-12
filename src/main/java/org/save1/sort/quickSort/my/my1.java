package org.save1.sort.quickSort.my;

public class my1 {
    public static void  quickSort(int[] nums,int left ,int right){
        if(left>=right){
            return;
        }
//        这么简单的分治都写错了啊
           int part=partition(nums,left,right);
           quickSort(nums,left,part-1);
           quickSort(nums,part+1,right);

    }
    public static  int partition(int[] nums,int left,int right){
        if(left>=right){
            return right;
        }
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
               //           注意这里是j--啊
               nums[j--]=nums[i];
           }


        }
        nums[i]=priotValue;
        return i;

    }
    public static void main(String[] args) {
        int[] a = {54, 6, 67, 3, 7, 8, 3, 6, 88, 44, 67, 51, 78, 90};
        int[] arr = {3,1,6};
        quickSort(a, 0, arr.length - 1);
        for (int ai : a) {
            System.out.print(ai + " ");

        }
    }
}
