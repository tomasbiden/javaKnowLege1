package org.bolin.algorithm.greedy;

class L376wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
    public static void main(String[] args){
        L376wiggleMaxLength l376wiggleMaxLength = new L376wiggleMaxLength();
        int[] example=new int[]{2,2};
        int i = l376wiggleMaxLength.wiggleMaxLength(example);
        int h=1;


    }
}