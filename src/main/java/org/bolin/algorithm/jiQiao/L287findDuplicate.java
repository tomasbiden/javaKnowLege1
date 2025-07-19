package org.bolin.algorithm.jiQiao;

class  L287findDuplicate_250707_1{
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[nums[0]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int pre1=0;
        int pre2=slow;
        while (pre1!=pre2){
            slow=nums[slow];
            fast=nums[fast];
        }
        return pre1;
    }
}
public class L287findDuplicate {
}
