package org.bolin.algorithm.doublePointer.Leecode.L11maxArea;

class L11_250702_1{
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int result=0;
        while (left<right){
//           注意间距不用+1的啊
            result=Math.max(result,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return result;
    }
}
public class L11maxArea {
}
