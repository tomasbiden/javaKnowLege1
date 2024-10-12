package org.save1.List.niuke.BM6;

import org.save1.List.Test.Test1;
import org.save1.List.model.ListNode;

public class BM6 {

    public static  boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return  true;
            }
        }
        return false;

    }
    public static void main(String[] args){
        ListNode head = Test1.testBM6();
        boolean bool=hasCycle(head);
        System.out.println(hasCycle(head));


    }

    public static void main2(String[] args){
        /*
        // 新建一个 BufferedInputStream 对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("input.txt"));
// 读取文件的内容并复制到 String 对象中
        String result = new String(bufferedInputStream.readAllBytes());
        System.out.println(result);

         */









    }
}
