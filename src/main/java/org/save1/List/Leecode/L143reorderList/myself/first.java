package org.save1.List.Leecode.L143reorderList.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

import java.util.ArrayList;

public class first {

    public void reorderList(ListNode head) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode node=head;
        listNodes.add(head);
        while (node!=null){
            listNodes.add(node);
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
