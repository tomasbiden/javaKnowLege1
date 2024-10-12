package org.algorithm.sort.diKda;


//这个算法十分优秀
public class E_third {
    public static int quickselect(int[] a, int l, int r,int k) {
            if(l>=r){
                return  a[l];

            }

            int i,j,x;

            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while(i < j && a[j] > x)
                    j--; // 从右向左找第一个小于等于x的数
                if(i < j)
                    a[i++] = a[j];
                while(i < j && a[i] < x)
                    i++; // 从左向右找第一个大于等于x的数
                if(i < j)
//                        他这里不用=号的原因就是他是 a[j--]
                    a[j--] = a[i];
            }
            a[i] = x;
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

}
