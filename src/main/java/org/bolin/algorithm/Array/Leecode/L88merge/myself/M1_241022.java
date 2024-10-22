package org.bolin.algorithm.Array.Leecode.L88merge.myself;

public class M1_241022 {
//  1  2
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;

        int k=m+n-1;
        while (i>=0||j>=0){
            if(i==-1){
                nums1[k--]=nums2[j--];
                continue;
            }
            if(j==-1){
                nums1[k--]=nums1[i--];
                continue;
            }

           nums1[k--]= nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
//            不要乱 return 啊
//            return;
        }

    }

}
