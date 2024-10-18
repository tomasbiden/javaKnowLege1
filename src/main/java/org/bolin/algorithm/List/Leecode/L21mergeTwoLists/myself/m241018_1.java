package org.bolin.algorithm.List.Leecode.L21mergeTwoLists.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

public class m241018_1 {

    public ListNode mergeTwoLists_errot(ListNode list1, ListNode list2) {
        if(list1==null||list2==null){
            return  list1==null?list2:list1;
        }
        ListNode p1=list1;
        ListNode p2=list2;
        while (p1!=null&&p2!=null){
            if(p1.val>p2.val){
                ListNode tmp=p2.next;
                p2.next=p1;
//                注意要修改p的值
                p2=tmp;
            }else {
                ListNode tmp=p1.next;
                p1.next=p2;
                p1=tmp;
            }
        }

        return  list1.val<=list2.val?list1:list2;

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null||list2==null){
            return  list1==null?list2:list1;
        }
        ListNode p1=list1;
        ListNode p2=list2;
//        优先p1进行选择
       if(p1.val<=p2.val){
           p1.next=mergeTwoLists(p1.next,p2);
       }else {
           p2.next=mergeTwoLists(p1,p2.next);
       }

        return  list1.val<=list2.val?list1:list2;

    }
}
