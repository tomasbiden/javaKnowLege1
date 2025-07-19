package org.bolin.algorithm.List.Leecode.L2addTwoNumbers;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

class L2addTwoNumbers_250719_1{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersWithCarry(0,l1,l2);

    }

    private ListNode addTwoNumbersWithCarry(int carry,ListNode l1,ListNode l2){

        if(l1==null&&l2==null&&carry==0){
            return null;
        }

        int sum=carry;
        if(l1!=null){
//           1:sum 放到前面啊
            sum+=l1.val;
            l1=l1.next;

        }
        if(l2!=null){
            sum+=l2.val;
            l2=l2.next;

        }
        return new ListNode(sum%10,addTwoNumbersWithCarry(sum/10,l1,l2));
    }
}
public class L2addTwoNumbers {
}
