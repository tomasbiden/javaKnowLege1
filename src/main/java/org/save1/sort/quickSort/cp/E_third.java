package org.save1.sort.quickSort.cp;

public class E_third {


// 这个也能通过

    /*
     * 快速排序
     *
     * 参数说明:
     *     a -- 待排序的数组
     *     l -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     *     r -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    public static void quickSort(int[] a, int l, int r) {

            if(l>=r){
                return;
            }
            int i=partition(a,l,r);
            quickSort(a, l, i - 1); /* 递归调用 */
            quickSort(a, i + 1, r); /* 递归调用 */

    }

    public static int  partition(int[] a, int l ,int r){
        int i=l;
        int j=r;
        int x=a[l];
//         注意这里是i < j 而不是 i<r
        while (i<j){
            while (i<j&&a[j]>x){
                j--;
            }
            if(i<j){
                a[i]=a[j];
                i++;
            }
            while (i<j&&a[i]<x){
                i++;
            }
            if(i<j){
//                这里是 j--而不是 j++
                a[j]=a[i];
                j--;
            }
        }
        a[i]=x;
        return i;

    }

    public static void main(String[] args) {
        int i;
        int a[] = {3, 1, 6, 3};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        quickSort(a, 0, a.length - 1);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }


}
