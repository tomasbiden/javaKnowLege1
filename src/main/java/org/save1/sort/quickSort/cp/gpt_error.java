package org.save1.sort.quickSort.cp;

import java.util.Arrays;

public class gpt_error {
    // 主函数，调用快速排序
    public static void main(String[] args) {
        int[] array = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("Unsorted array: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    // 快速排序的递归函数
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 获取划分点
            int pi = partition(arr, low, high);

            // 对划分点左边部分进行排序
            quickSort(arr, low, pi - 1);
            // 对划分点右边部分进行排序
            quickSort(arr, pi + 1, high);
        }
    }

    // 划分函数，选取最后一个元素作为基准
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // 选取最后一个元素作为基准
        int i = (low - 1); // 记录小于基准的元素的最后一个位置

        for (int j = low; j < high; j++) {
            // 当前元素小于基准元素
            if (arr[j] < pivot) {
                i++;
                // 交换arr[i]和arr[j]
                swap(arr, i, j);
            }
        }

        // 交换基准元素和i+1位置上的元素
        swap(arr, i + 1, high);

        return i + 1; // 返回划分点的位置
    }

    // 辅助函数，用于交换数组中的两个元素
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
