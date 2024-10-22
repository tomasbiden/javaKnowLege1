package org.bolin.algorithm.List.Leecode.L92reverseBetween.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class M1_241022 {

// 25  60
// 1  2  3  4  5
    public  void reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
//         这不是 head!=null
        while (cur!=null){
            ListNode curNext=cur.next;

            cur.next=pre;
            pre=cur;
            cur=curNext;
        }

    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode();
//        不要忘记 dumm.next的设置啊
        dummy.next=head;
//     这里要默认为 dummy  与 reverseLeft 否则当 i为1  时，有空指针异常
        ListNode reverseLeftPre = dummy;
        ListNode reverseLeft=dummy.next;
        ListNode reverseRight=null;
        ListNode  reverseRightNext=null;

        ListNode cur=dummy;

        dummy.next=head;
        for(int i=1;i<=right;i++){
            cur=cur.next;

            if(i==left-1){
                reverseLeftPre=cur;
                reverseLeft=reverseLeftPre.next;
            }

            if(i==right){
                reverseRight=cur;
                reverseRightNext=reverseRight.next;
            }

        }
//        怎么把截断的这句删掉了呢
        reverseRight.next=null;

        reverseList(reverseLeft);
        reverseLeftPre.next=reverseRight;

//        reverseRight.next=reverseRightNext;   这句错误了啊
        reverseLeft.next=reverseRightNext;

        return dummy.next;



    }
}
