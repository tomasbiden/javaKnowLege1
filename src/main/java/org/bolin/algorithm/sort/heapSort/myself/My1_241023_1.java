package org.bolin.algorithm.sort.heapSort.myself;

public class My1_241023_1 {
//30 min
//    1  2  3  6
    public void adjustHeap(int[] nums,int index,int len){
//    可能是这个括号的问题啊 ，确实是这里的问题啊
        int lchild=index<<1+1;
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

    public int[] heapSort(int[] nums){
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
        for(int i=len-1;i>=0;i--){
            int tmp=nums[i];
            nums[i]=nums[0];
            nums[0]=tmp;

            adjustHeap(nums,0,i);
        }

        return nums;

    }

    public static void main(String[] args){
        /*
        int[] nums= new int[]{1,2,3,5,6,7};
        My1_241023_1 my12410231 = new My1_241023_1();
        my12410231.adjustHeap(nums,0,nums.length);
        for (int num : nums) {
            System.out.print(num+" ");

        }

         */
//        my12410231.heapSort(nums);
        int x= 2<<1+1;
        int y= 2+1<<1;
        System.out.println(x+" "+ y);


    }


}
