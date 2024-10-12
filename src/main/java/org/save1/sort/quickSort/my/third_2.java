package org.save1.sort.quickSort.my;

public class third_2 {
    public static void quickSort(int[] a,int l,int r){
        if(l>=r){
            return ;
        }
       int pi=partition(a,l,r);
       quickSort(a,l,pi-1);
       quickSort(a,pi+1,r);


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

}
