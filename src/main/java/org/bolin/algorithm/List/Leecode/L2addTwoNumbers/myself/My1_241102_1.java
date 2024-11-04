package org.bolin.algorithm.List.Leecode.L2addTwoNumbers.myself;

import org.save1.codeSuiXiangLu.List.ListNode.ListNode;

// 2
public class My1_241102_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode  dummy=new ListNode(-1);
        ListNode  pre=dummy;
        int flag=0;
        while (l1!=null||l2!=null){
            int sum=0;
            if(l1==null&&l2==null){
                return  dummy.next;
            }
            if(l1==null){
                 sum=(l2.val+flag)%10;
                flag=(l2.val+flag)/10;
            
    
//                注意while的值更新啊
                l2=l2.next;
            
            }
            if(l2==null){


                 sum=(l1.val+flag)%10;
                flag=(l1.val+flag)/10;
                
                l1=l1.next;
           

            }
            if(l1!=null&&l2!=null){
              sum=(l1.val+l2.val+flag)%10;
                flag=(l1.val+l2.val+flag)/10;
            }
           
            ListNode newNode = new ListNode(sum);
            pre.next=newNode;
            pre=newNode;

            l1=l1.next;
            l2=l2.next;
            continue;


        }
        return  dummy.next;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode  dummy=new ListNode(-1);
        ListNode  pre=dummy;
        int flag=0;
        while (l1!=null||l2!=null||flag!=0){
           int l1Value=l1==null?0:l1.val;
           int l2Value=l2==null?0:l2.val;
           int sum=(l1Value+l2Value+flag)%10;
           flag=(l1Value+l2Value+flag)/10;

            ListNode newNode = new ListNode(sum);
            pre.next=newNode;
            pre=newNode;

            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }



        }
        return  dummy.next;
    }
}
