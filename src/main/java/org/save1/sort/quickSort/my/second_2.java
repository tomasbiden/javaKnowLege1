package org.save1.sort.quickSort.my;

public class second_2 {
    public static void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int priot = a[l];
        int i = l;
        int j = r;
        while (i < j) {
//            注意一定是有等于号的啊
            while (i < j && a[j] >=priot) {
                j--;

            }
            while (i < j && a[i] <priot) {
                i++;

            }

            if(i<j){
                int tmp=a[j];
                a[j]=a[i];
                a[i]=tmp;
            }

        }
//        这里不能只赋值，而是要进行swap
        int tmp=a[i];
        a[i]=a[l];
        a[l]=tmp;

        quickSort(a, l, i-1);
        quickSort(a, i+1, r);
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0, nums.length-1);
        return nums;
    }

    public static void main(String[] args) {
//        int[] a = {54, 6, 67, 3, 7, 8, 3, 6, 88, 44, 67, 51, 78, 90};
        int[] a = {3,1,6,3};
        quickSort(a, 0, a.length - 1);
        for (int ai : a) {
            System.out.print(ai + " ");

        }
    }
}
