package org.bolin.algorithm.List.Leecode.L143reorderList.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

import java.util.HashMap;

/*

class Solution {
    public void reorderList(ListNode head) {
                ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode node=head;
        // listNodes.add(head);
        while (node!=null){
            listNodes.add(node);
            node=node.next;
        }
        int i=0; int j=listNodes.size()-1;
        while (i<=j){
            if(i==j){
                listNodes.get(i).next=null;
                break;

            }
            if(j-i==1){
                listNodes.get(j).next=null;
                break;
            }
            listNodes.get(i).next=listNodes.get(j);
            listNodes.get(j).next=listNodes.get(i+1);
            i++;
            j--;
        }

    }
}
 */
public class my1_241025_hashMap {


    public  static void reorderList(ListNode head) {
        if(head==null){
            return;
        }

        HashMap<Integer, ListNode> hashMap = new HashMap<>();
        ListNode cur=head;
        int i=0;
        while (cur!=null){
            hashMap.put(++i,cur);
            cur=cur.next;
        }
        int len=i;
        int j=i;  i=1;
        while (i<j){
            ListNode left = hashMap.get(i);
            ListNode right = hashMap.get(j);
            /*  这里明显的错误的啊 .left.next已经更新了啊
            left.next=right;
            right.next=left.next;

             */

            left.next=right;
            right.next=hashMap.get(i+1);
            i++;
            j--;
        }
        hashMap.get(len/2+1).next=null;
        return ;


    }
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        reorderList(listNode1);
        ListNode cur=listNode1;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }



    }
}
