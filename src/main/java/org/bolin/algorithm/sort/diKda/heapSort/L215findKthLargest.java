package org.bolin.algorithm.sort.diKda.heapSort;

class FindKthLargest_250706_1{

    public int findKthLargest(int[] nums, int k) {
            buildMaxHeap(nums,nums.length);
            for(int i=nums.length-1;i>=nums.length-1-(k-2);i--){
                swap(nums,0,i);
                maxHeapify(nums,i,0);
            }
            return nums[0];
    }
    private void maxHeapify(int[] nums,int heapSize,int i){
        int largerIndex=i;
        int leftIndex=i*2+1;
        int rightIndex=i*2+2;
        if(leftIndex<heapSize&&nums[largerIndex]<nums[leftIndex]){
            largerIndex=leftIndex;
        }
        if(rightIndex<heapSize&&nums[largerIndex]<nums[rightIndex]){
            largerIndex=rightIndex;
        }
        if(largerIndex!=i){
            swap(nums,i,largerIndex);
//           largerIndex不是i
            maxHeapify(nums,heapSize,largerIndex);

        }
    }

    private void buildMaxHeap(int[] nums,int heapSize){
        for(int i=heapSize/2-1;i>=0;i--){
            maxHeapify(nums,heapSize,i);
        }
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public static void main(String[] args){
        FindKthLargest_250706_1 findKthLargest2507061 = new FindKthLargest_250706_1();
        findKthLargest2507061.findKthLargest(new int[]{3,2,1,5,6,4},2);

    }

}


public class L215findKthLargest {
}
