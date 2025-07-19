package org.bolin.algorithm.sort.heapSort.L347topKFrequent;

import java.util.*;

class L347topKFrequent_250706_1{
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> numberCntMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numberCntMap.merge(nums[i],1,Integer::sum);
        }
        int maxCnt=Collections.max(numberCntMap.values());
        int[] cntArray=numberCntMap.values().stream().mapToInt(Integer::intValue).toArray();
        List<Integer>[] cntNumberMap=new ArrayList[maxCnt+1];
        Arrays.setAll(cntNumberMap,i->new ArrayList<>());
        for (Map.Entry<Integer, Integer> numberCntEntrySet : numberCntMap.entrySet()) {
            Integer number = numberCntEntrySet.getKey();
            Integer cnt = numberCntEntrySet.getValue();
            cntNumberMap[cnt].add(number);
        }
        int[] ans=new int[k];
        int j=0;
//        1:ans.length<k 错误
        for(int i=maxCnt;i>=0&&k<k;i--){
            for (Integer number : cntNumberMap[i]) {
                ans[j++]=number;
            }
        }
        return ans;


    }
    public static void main(String[ ] args){
        L347topKFrequent_250706_1 l347topKFrequent2507061 = new L347topKFrequent_250706_1();
        l347topKFrequent2507061.topKFrequent(new int[]{1,1,1,2,2,3},2);

    }

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
}
public class L347topKFrequent {
}
