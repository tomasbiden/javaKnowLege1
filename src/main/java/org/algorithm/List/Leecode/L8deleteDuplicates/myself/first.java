package org.algorithm.List.Leecode.L8deleteDuplicates.myself;

import org.algorithm.codeSuiXiangLu.List.ListNode.ListNode;

import java.util.HashMap;

//错误代码，只删除了重复的代码，没有删除所有代码,这个代码还是有问题，只能去除1次重复的
public class first {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyNode=new ListNode(-1);
        ListNode dummyNode2=new ListNode(-2);
        dummyNode.next=head;
        dummyNode2.next=dummyNode;

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        ListNode  pre2=dummyNode2;
        ListNode  pre=dummyNode;
        ListNode  cur=pre.next;
        while (cur!=null){
//            cur=pre.next;
            if(hashMap.containsKey(cur.val)){
//                注意要有.next
//                pre2.next=cur.next;
                pre=cur.next;
                pre2.next=pre;
                if(pre!=null){
                    cur=pre.next;
                }else {
                    break;
                }
                continue;
            }else {
                hashMap.put(cur.val,cur.val);
                pre2=pre;
                pre=cur;
                cur=cur.next;

            }

        }
        return  dummyNode.next;




    }
}
