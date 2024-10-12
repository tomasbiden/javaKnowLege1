package org.save1.codeSuiXiangLu.String.secondeReverseStringII;

public class first {
    public String reverseStr(String s, int k) {
        int start=0;
        int len=s.length();
        StringBuffer res = new StringBuffer();
        while (start<s.length()){
//            注意这里是大于符号，而且最好来说打上括号
            int firstK=(start+k>len)?len:start+k;
            int secondK=(start+2*k>len)?len:start+2*k;
            StringBuffer tmp = new StringBuffer();
            tmp.append(s.substring(start,firstK));
            tmp.reverse();
            res.append(tmp);
            if(secondK>firstK){
                res.append(s.substring(firstK,secondK));

            }
//            迭代条件注意不能漏掉啊
            start+=(2*k);

        }
        return res.toString();
    }
}
