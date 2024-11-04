package org.bolin.algorithm.List.Leecode.L21mergeTwoLists.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;
//
public class My1_241102_1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return  list2;
        }
        if(list2==null){
            return list1;
        }
//        这两个<=要匹配才行的啊，要不然会出错误的
        if(list1.val<=list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
        }else {
            list2.next=mergeTwoLists(list1,list2.next);
        }
        return list1.val<=list2.val?list1:list2;
    }
}
