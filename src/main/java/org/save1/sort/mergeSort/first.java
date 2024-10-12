package org.save1.sort.mergeSort;

public class first {
    public static int[] mergeSort(int[] a,int l,int r){
        int mid=l+(r-l)/2;
        if(l<r){
            mergeSort(a,l,mid);
            mergeSort(a,mid+1,r);
            mergeArray(a,l,mid,r);
        }
        return  a;
    }

    private static void mergeArray(int[] a, int l, int mid, int r) {
        int[] tmp=new int[r-l+1];
        int i=l;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<=r){
            if(a[i]<a[j]){
                tmp[k++]=a[i++];
            }else {
                tmp[k++]=a[j++];
            }
        }

        while (i<=mid){
            tmp[k++]=a[i++];
        }
//        注意复制后是a[j++]而不是a[i++]
        while (j<=r){
            tmp[k++]=a[j++];
        }
        for(int x=0;x<tmp.length;x++){
            a[l+x]=tmp[x];
        }
    }
}
