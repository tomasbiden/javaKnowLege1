package org.bolin.algorithm.stack;



import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class  L394decodeString_250705_1{
    public String decodeString(String s) {

        Deque<Integer> numberQueue=new ArrayDeque<>();
        Deque<StringBuilder> preStringQueue=new ArrayDeque<>();
        StringBuilder result=new StringBuilder();
        int num=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                result.append(c);
            }
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                num=num*10+s.charAt(i)-'0';
            }
            if(s.charAt(i)=='['){
                numberQueue.push(num);
                preStringQueue.push(result);
//
//              2  num=1; 错误
                  num=0;
                result=new StringBuilder();
            }
            if(c==']'){
                StringBuilder middleSb=new StringBuilder();
                int tmpNum=numberQueue.pop();
                for(int j=0;j<tmpNum;j++){
                    middleSb.append(result);
                }
//               1: result.append(preStringQueue).append(middleSb);
                result=preStringQueue.pop().append(middleSb);

            }

        }
        return result.toString();
    }
}
public class L394decodeString {
}
