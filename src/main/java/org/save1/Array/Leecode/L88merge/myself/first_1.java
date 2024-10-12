package org.save1.Array.Leecode.L88merge.myself;

public class first_1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int tail=m+n-1;
        while (p1>=0||p2>=0){
            if(p1==-1){
                nums1[tail--]=nums2[p2--];
                continue;
            }
            if(p2==-1){
                nums1[tail--]=nums1[p1--];
                continue;
            }
            if(nums1[p1]<nums2[p2]){
                nums1[tail--]=nums2[p2--];
            }else {
                nums1[tail--]=nums1[p1--];
            }
        }
    }
}
