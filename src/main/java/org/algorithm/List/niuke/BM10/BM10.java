package org.algorithm.List.niuke.BM10;

import org.algorithm.List.model.ListNode;

public class BM10 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
//            调换指针位置是十分关键的啊
            /*
            p1=(p1==null)?p2:p1.next;
            p2=(p2==null)?p1:p2.next;
             */
//            是回到头指针而不是回到遍历指针
            p1=(p1==null)?pHead2:p1.next;
            p2=(p2==null)?pHead1:p2.next;

        }
        return p1;


    }
}
