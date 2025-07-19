package org.bolin.algorithm.jiQiao;
class L31nextPermutation_250707_1{
    public void nextPermutation(int[] nums) {

        int n=nums.length;
        int i=n-2;
//       i+1 不是i-1
        while (i>=0&&!(nums[i]<nums[i+1])){
            i--;
        }
        int j=n-1;
        if(i>=0){

            while (!(nums[j]>nums[i])){
                j--;
            }
//            i错误,不要漏洞了啊 ,不是j，是n-1啊
            swap(nums,i+1,n-1);
        }
        reverse(nums,i,j);
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private void reverse(int[] nums,int i,int j){
        while (i<j){
            swap(nums,i++,j--);
        }
    }

}
public class L31nextPermutation
{
}
