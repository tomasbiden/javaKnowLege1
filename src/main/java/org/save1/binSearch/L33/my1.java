package org.save1.binSearch.L33;

public class my1 {
//         1  2 3 4 5   return 0

//         2 3 4 5 1  return 4 发生了错误了
//         3 4 5 1 2
//         4  5  1 2 3


//     0 1 2 3 4   return 4
    public static  int findPriot(int[] nums){
        int l=0 ; int r=nums.length-1;
        int len=nums.length;
        while (l<r){
            int mid=(r+l+1)/2;
            if(nums[mid]<nums[0]){
                r=mid-1;
            }else {
                l=mid;
            }
        }
        return  l;
    }
    public  static  int binSearch(int[] nums, int l,int r, int target){

        while (l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return  mid;
            }
            if(nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return  -1;

    }


    public int search(int[] nums, int target) {
        int priot=findPriot(nums);
        if(target>=nums[0]&&target<=nums[priot]){
            return  binSearch(nums,0,priot,target);
        }
        if(target<nums[0]&&priot+1<nums.length&&target>=nums[priot+1]){
            return binSearch(nums,priot+1,nums.length-1,target);

        }
        return  -1;


    }
    public static  void main(String[] args){
//        int[]  nums={4,5,6,7,0,1,2};
        int[]  nums={1,2,3,4,5,6,7};
        System.out.println();
        double x = 1.234;
        boolean a=true;


    }
}
