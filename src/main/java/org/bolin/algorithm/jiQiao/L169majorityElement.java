package org.bolin.algorithm.jiQiao;
class L169majorityElement_250706_1{

    public int majorityElement(int[] nums) {
        int candidate=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                candidate=nums[i];
            }
            cnt+=nums[i]==candidate?1:-1;
        }
        return candidate;
    }

}
public class L169majorityElement {
}
