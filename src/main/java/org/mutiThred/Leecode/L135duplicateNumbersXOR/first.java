package org.mutiThred.Leecode.L135duplicateNumbersXOR;

import java.util.HashSet;
import java.util.Set;

public class first {
//    Identifier expected
public static int duplicateNumbersXOR(int[] nums) {
    long bit3=0;
    int result=0;
    for (int num : nums) {
        if(((bit3>>num)&1)==0){
//            1 必选转为long ,不然会越界问题
            bit3^=((long)1<<num);
        }else {
            System.out.print(num+" ");
            result^=num;
        }

    }

    return  result;
}


        public static void duplicateNumbersXOR2(int[] nums) {
            Set<Integer> cnt = new HashSet<>();
            int res = 0;
            for (int num : nums) {
                if (cnt.contains(num)) {
                    System.out.print(num+" ");
                    res ^= num;
                } else {
                    cnt.add(num);
                }
            }

        }




    public static  void main(String[] args){
        int[] nums={2,14,47,34,19,29,4,38,10,5,45,10,18,11,28,12,39,20,50,9,28,27,36,35,41,35,23,21,5,18,3,11,3,29,25,46,45,42,43,19};
//        int[] nums={35,35};
        duplicateNumbersXOR(nums);
        System.out.println();
        duplicateNumbersXOR2(nums);
//        18  35 45
    }
}
