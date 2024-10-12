package org.algorithm.binSearch.L33;

public class cp1_1 {
    public int search(int[] nums, int target) {
        //         1  2 3 4 5   return 0

//         2 3 4 5 1  return 4 发生了错误了
//        我这里是假设  r已经是最小值，而r有的时候在最左边而根本不在右边啊
        int len=nums.length;
        int min=0;
        int l1=0;
        for( int l=0,r=len-1;l<=r;){
            int mid=(l+r)/2;
            if(nums[mid]<nums[0]){
                r=mid;

            }else {
                l=mid+1;
            }
            l1=l;
        }
        min=l1;
//        这里需要考虑一次特例情况啊
        if(nums[len-1]>nums[0]){
            min=0;
        }

        for(int l=min,r=l+len-1;l<=r;){
            int mid=(l+r)/2; int i=mid%len;
            if(target>nums[i]){
                l=mid+1;
            }else if(target<nums[i]){
                r=mid-1;
            }else {
                return i;
            }

        }
        return  -1;


    }
}
