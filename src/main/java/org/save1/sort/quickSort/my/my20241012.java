package org.save1.sort.quickSort.my;

import java.util.*;

public class my20241012 {
    public static int partition(int [] nums,int a,int b){
        if(a==b){
            return a;
        }
        int priot=nums[a];
        int l=a;
        int r=b;
        while (l<r){
            while (l<r&&nums[r]>priot){
                r--;
            }
            if(l<r){
                nums[l++]=nums[r];
            }
            while (l<r&&nums[l]<priot){
                l++;
            }
            if(l<r){
                nums[r--]=nums[l];
            }



        }
        nums[l]=priot;
        return l;

    }
    public static  void quickSort(int [] nums,int l,int r){
//        这里用大于等于比较好
        if(l>=r){
            return ;
        }
       int index=partition(nums,l,r);
       if(index-1>=l){
           quickSort(nums,l,index-1);
       }
       if(index+1<=r){
           quickSort(nums,index+1,r);
       }

    }
    public static int[] sortArray(int[] nums){
        quickSort(nums,0,nums.length-1);
        return  nums;
    }



    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int[] nums=new int[8];
        int i=0;
        while (scanner.hasNextInt()){
                nums[i++]=scanner.nextInt();
                System.out.print(nums[i-1]);

        }



    }
}
