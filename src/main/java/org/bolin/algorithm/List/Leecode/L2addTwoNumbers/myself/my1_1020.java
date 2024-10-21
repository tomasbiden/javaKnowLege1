package org.bolin.algorithm.List.Leecode.L2addTwoNumbers.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class my1_1020 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return  l1==null?l2:l1;
        }
        int flag=0;
        ListNode dummy=new ListNode(-1);

        ListNode cur=dummy;

//        注意保存输入值啊
        ListNode p1=l1;
        ListNode p2=l2;
        while (p1!=null||p2!=null){
            int value1=p1==null?0:p1.val;
            int value2=p2==null?0:p2.val;

            ListNode tmp=new ListNode((value1+value2+flag)%10);

            cur.next=tmp;
            cur=tmp;

//            注意这里也要加flag啊
            flag=(value1+value2+flag)/10;

//            递归条件不能忘记啊   ,注意要进行空值判断啊
            p1=p1==null?null:p1.next;
            p2=p2==null?null:p2.next;
        }
        if(flag==1){
            cur.next=new ListNode(1);

        }

        return  dummy.next;

    }
    public  static void main(String[] args){

    }
}
