package org.bolin.algorithm.List.Leecode.L21mergeTwoLists;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

class L21mergeTwoLists_250719_1{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null||list2==null){
            return list1==null?list2:list1;
        }
        if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
        }else {
            list2.next=mergeTwoLists(list1,list2.next);
        }
        return list1.val<list2.val?list1:list2;

    }
}
public class L21mergeTwoLists {
}
