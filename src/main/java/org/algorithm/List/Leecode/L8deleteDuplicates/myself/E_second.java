package org.algorithm.List.Leecode.L8deleteDuplicates.myself;

import org.algorithm.codeSuiXiangLu.List.ListNode.ListNode;

import java.util.HashMap;

public class E_second {
    //
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyNode = new ListNode(-1);
        ListNode dummyNode2 = new ListNode(-2);
        dummyNode.next = head;
        dummyNode2.next = dummyNode;

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        ListNode pre2 = dummyNode2;
        ListNode pre = dummyNode;
        ListNode cur = pre.next;
        while (cur != null) {
//
            int flag=0;
            while (cur.val == pre.val) {
                cur = cur.next;
                flag=1;
                if (cur == null) {
                    break;
                }
            }
            if(flag==1){
                pre2.next=cur;
                pre=cur;
                if(cur==null){

                }else {
                    cur=cur.next;
                }
            }else {
                pre2 = pre;
                pre = cur;
                cur = cur.next;

            }





        }
        return dummyNode.next;


    }
}
