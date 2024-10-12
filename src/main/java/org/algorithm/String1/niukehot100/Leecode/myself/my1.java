package org.algorithm.String1.niukehot100.Leecode.myself;

public class my1 {
    public String addStrings(String num1, String num2) {
        StringBuffer sb= new StringBuffer();
        int i=num1.length()-1;
        int j=num2.length()-1;
        int flag=0;
        while (i>=0||j>=0){
            int a=0;
            int b=0;

            if(i>=0){
                a=num1.charAt(i)-'0';
            }
            if(j>=0){
                b=num2.charAt(j)-'0';
            }

            i--;
            j--;

            sb.append((a+b+flag)%10);
//            这个要放到下面啊
            flag=(a+b+flag)/10;



        }
        if(flag>0){
            sb.append(flag);
        }
        return  sb.reverse().toString();



    }

    public String reverseString(String s){
        char[] charArray = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while (i<j){
            char tmp=charArray[i];
            charArray[i]=charArray[j];
            charArray[j]=tmp;


        }


        return  new String(charArray);
    }
}
