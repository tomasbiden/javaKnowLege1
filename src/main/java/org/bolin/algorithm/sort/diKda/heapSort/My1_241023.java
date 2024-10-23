package org.bolin.algorithm.sort.diKda.heapSort;

public class My1_241023 {
    public void adjustHeap(int[] nums,int index,int len){
//    可能是这个括号的问题啊 ，确实是这里的问题啊
        int lchild=(index<<1)+1;
        int rchild=(index<<1)+2;

        int lValue=lchild>=len?Integer.MIN_VALUE:nums[lchild];
        int rValue=rchild>=len?Integer.MIN_VALUE:nums[rchild];

//         这里是 < 而不是 小于等于啊
        if(lchild<len){
            int mchild=lValue>rValue?lchild:rchild;
            int mValue=nums[mchild];
            if(nums[index]<mValue){
                nums[mchild]=nums[index];
                nums[index]=mValue;
                adjustHeap(nums,mchild,len);
            }
        }

    }

    public  int findKthLargest(int[] nums,int k){

        int len=nums.length;
        /*  一定是从后往前而不是从前往后
        for(int i=0;i<=(nums.length/2);i++){
            adjustHeap(nums,i,len);
        }
        这里顺序可能错误了
         */

        for(int i=(nums.length/2);i>=0;i--){
            adjustHeap(nums,i,len);
        }
        for (int num : nums) {
            System.out.print(num+" ");

        }
//        第k大  index 为 len-k
        int i=len-1;
        for(i=len-1;i>=len-k;i--){
            int tmp=nums[i];
            nums[i]=nums[0];
            nums[0]=tmp;

            adjustHeap(nums,0,i);
        }
//     注意返回值一定是 i+1,  因为有i--的作用的啊
//        return nums[i+1];
//        不要同通过i来确定，直接通过 len-k就一定是不会错误的啊
        return  nums[len-k];

    }
}
