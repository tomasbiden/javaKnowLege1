package org.algorithm.String1.Leecode.L8myAtoi.myself;

public class my2 {

    public static  int myAtoi(String s) {

        char[] charArray = s.toCharArray();
        int len=charArray.length;
        int i=0;
        int flag=1;
        int res=0;

            while (i<len&&charArray[i]==' '){
                i++;
            }

//            这里不要写成双if啊
            if(i<len&&charArray[i]=='+'){
                i++;
            }else if(i<len&&charArray[i]=='-'){
                flag=-1;
                i++;
            }

//            i++这样子写实有问题  ,  注意数组越界问题啊
            while (i<len&&charArray[i]=='0'){
                i++;

            }



            while (i<len){
                if(!Character.isDigit(charArray[i])){
                    break;
//                    return (int)res;
                }
                if(res>(Integer.MAX_VALUE-(charArray[i]-'0'))/10){
                    return  flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                res=res*10+charArray[i]-'0';
                i++;


            }




        return res*flag;

    }
    public static void main(String[] args){
        String s="  -0012a42";
//        s="-42";
        System.out.println(myAtoi(s)+" ");
        System.out.println(Integer.MIN_VALUE/10);

    }
}
