package org.algorithm.sort.diKda;

class E_myself {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums,0,nums.length-1,k);
    }

    public static int quickselect(int[] a, int l, int r,int k) {
        if (l >= r) {
            return a[l];
        }

        int i=partition(a,l,r);

        if((r-i+1)<k){
//              错误的，自认为从0开始
//            return  quickselect(nums,i+1,r,k-(i+1));
            return  quickselect(a,l,i-1,k-(r-i+1));
        }
        if((r-i+1)>k){
//            return quickselect(nums,l,i-1,k-(r-i+1));
            return quickselect(a,i+1,r,k);

        }
        return  a[i];

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