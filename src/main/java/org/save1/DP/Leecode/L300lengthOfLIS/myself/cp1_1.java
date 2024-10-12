package org.save1.DP.Leecode.L300lengthOfLIS.myself;

import java.util.Arrays;

public class cp1_1 {

    public static  int  binSearch(int[] d,int num,int tmpMaxLen){
        int i=0; int j=tmpMaxLen;

        while (i<j){
//            通过+1使得优先向右搜索
            int mid=i+(j-i+1)/2;
            if(d[mid]>=num){
                j=mid-1;
            }else {
                i=mid;
            }
        }
        return  i;

    }
    public int lengthOfLIS(int[] nums) {
        int tmpMaxLen=0;
        int len=nums.length;
        int[] d=new int[len+1];
        Arrays.fill(d,0);
//        通过d[0] 保证对于任何一个数都能找到小于 x 的最大的的数字
        d[0]=-40001;
        for(int i=0;i<len;i++){
//            d[tmpMaxLen]  而不是 d[i]
            if(d[tmpMaxLen]<nums[i]){
                d[++tmpMaxLen]=nums[i];
            }else {
                d[binSearch(d,nums[i],tmpMaxLen)+1]=nums[i];
            }

        }

        return  tmpMaxLen;



    }
}
