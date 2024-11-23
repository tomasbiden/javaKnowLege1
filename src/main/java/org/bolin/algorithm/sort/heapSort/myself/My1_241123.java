package org.bolin.algorithm.sort.heapSort.myself;

public class My1_241123 {
    public static void swap(int[] nums,int aIndex,int bIndex){
        int tmp=nums[aIndex];
        nums[aIndex]=nums[bIndex];
        nums[bIndex]=tmp;
    }
    public static void adjustHeap(int[] nums,int rootIndex,int maxIndex){
        int lChild=rootIndex*2+1;
        int rChild=rootIndex*2+2;

        if(lChild>maxIndex){
            return;
        }
        int greaterChildIndex;
        if(rChild>maxIndex){
             greaterChildIndex=lChild;
        }else {
            greaterChildIndex=nums[lChild]>=nums[rChild]?lChild:rChild;
        }

        if(nums[rootIndex]<nums[greaterChildIndex]){
            swap(nums,rootIndex,greaterChildIndex);
            adjustHeap(nums,greaterChildIndex,maxIndex);
        }


    }

    public static void HeapSort(int[] nums){
        int len=nums.length;
        int maxIndex1=len-1;
        for(int i=len/2;i>=0;i--){
            adjustHeap(nums,i,maxIndex1);
        }

        for(int i=maxIndex1;i>=0;i--){
            swap(nums,i,0);
            adjustHeap(nums,0,i-1);
        }
    }
    public static void main(String[] args){
        int[] nums={8,7,6,25,3,30,66};
        HeapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
