package org.bolin.algorithm.List.Leecode.L148sortList;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

class L148sortList_250720_1{
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
//            return  null 错误
            return head;
        }
        ListNode middle = findMiddle(head);
        
        ListNode head2=middle.next;
        middle.next=null;

        ListNode newHead1 = sortList(head);
//       注意是head2啊
        ListNode newHead2 = sortList(head2);

        return mergeTwoList(newHead1,newHead2);


    }

    private ListNode mergeTwoList(ListNode list1,ListNode list2){
        if(list1==null||list2==null){
            return list1==null?list2:list1;
        }
        if(list1.val<list2.val){
            list1.next=mergeTwoList(list1.next,list2);
            return list1;
        }else {
            list2.next=mergeTwoList(list1,list2.next);
            return list2;
        }
    }

    private ListNode findMiddle(ListNode head){
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
        ListNode slow=dummyNode;
        ListNode fast=dummyNode;


        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static void main(String[] args){
        // 手动构造链表 [4, 2, 1, 3]
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        L148sortList_250720_1 l148sortList2507201 = new L148sortList_250720_1();
        l148sortList2507201.sortList(head);

    }



}























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
