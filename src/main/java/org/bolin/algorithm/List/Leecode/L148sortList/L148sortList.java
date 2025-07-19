package org.bolin.algorithm.List.Leecode.L148sortList;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

class L148sortList_250710_1{
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode middleNode = getMiddleNode(head);
//       注意重新赋 head 和 middleNode值
        head=sortList(head);
        middleNode=sortList(middleNode);
        return  mergeTowList(head,middleNode);


    }
    private ListNode getMiddleNode(ListNode head){
        ListNode pre=head;
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        return slow;
    }

    private ListNode mergeTowList(ListNode list1,ListNode list2){
        if(list1==null||list2==null){
            return list1==null?list2:list1;
        }

        ListNode dummyNode=new ListNode();
        ListNode cur=dummyNode;
        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                 cur.next=list1;
                list1=list1.next;
                cur=cur.next;
            }else {
                cur.next=list2;
                list2=list2.next;
                cur=cur.next;
            }

        }
        cur.next=list1==null?list2:list1;

        return dummyNode.next;

    }
}
public class L148sortList {


}
