package org.algorithm.List.Leecode.L8deleteDuplicates.myself.cp1;

import org.algorithm.codeSuiXiangLu.List.ListNode.ListNode;

public class first {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode=new ListNode(-10);
        dummyNode.next=head;
        ListNode cur=dummyNode;
        while (cur!=null&&cur.next!=null&&cur.next.next!=null){

//            ListNode tmp=cur.next.next.next; 放到这里是错误的啊
//            之前将cur 直接向前走而没有保存 cur ，新建一个 ListNode变量，导致了节点的未改变
//            cp1里面的代码是通过遇到一个相等跳过一个，而我是找到最后一个再进行跳过
            if(cur.next.val==cur.next.next.val){
                ListNode tmp=cur.next.next.next;
                int value=cur.next.val;
                while (tmp!=null&&tmp.val==value){
                    tmp=tmp.next;
                }
                cur.next=tmp;

            }else {
                cur=cur.next;
            }

        }
        return  dummyNode.next;

    }
}
