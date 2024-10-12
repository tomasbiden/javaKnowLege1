package org.algorithm.sort.heapSort;

import java.util.Arrays;

public class first {
    public  static  void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public static void heapSort(int[] arr){
        int len=arr.length;
//        注意这里是j>=0，这里是进行堆化的过程
        for(int j=len/2-1;j>=0;j--){
            adjustHeap(arr,j,len);
        }
//        注意这里是j--啊
        for(int j=len-1;j>0;j--){
//            System.out.println(j);
            swap(arr,j,0);
            adjustHeap(arr,0,j);
        }
    }
    public   static  void adjustHeap(int[] arr,int parent,int len){
        int lchild=parent*2+1;
//        注意这里是>=  ， 这里是临界判断
        if(lchild>=len){
            return;
        }
        int schild=lchild;
        if(lchild+1<len&& arr[lchild]<arr[lchild+1]){
            schild=lchild+1;
//            这里是选择更大子点
        }
        if(arr[schild]<=arr[parent]){
            return;
        }
        swap(arr,schild,parent);
        adjustHeap(arr,schild,len);
    }
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    public static void main(String[] args){
        int arr[] = {4, 6, 8, 5, 9};
        System.out.println("排序前" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
    }
}
