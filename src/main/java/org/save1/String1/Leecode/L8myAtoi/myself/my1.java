package org.save1.String1.Leecode.L8myAtoi.myself;

public class my1 {

    public static  int myAtoi(String s) {

        char[] charArray = s.toCharArray();
        int len=charArray.length;
        int i=0;
        int flag=1;
        long res=0;
        while (i<len){
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

//            起始字符判断
            if(i<len&&!Character.isDigit(charArray[i])){
                return 0;
            }else if(i<len){
                res=flag*(charArray[i]-'0');
                i++;
            }


            while (i<len){
                if(!Character.isDigit(charArray[i])){
                    return (int)res;
                }else {
                    if(flag==1){

                        res=(res*10+flag*(-'0'+charArray[i])>Integer.MAX_VALUE)?(int)Integer.MAX_VALUE:res*10-'0'+charArray[i];

                    }
                    if(flag==-1){

                        res=(res*10-(charArray[i]-'0')<Integer.MIN_VALUE)?(int)Integer.MIN_VALUE:res*10-(charArray[i]-'0');
                    }
//                    注意i的迭代更新不能漏掉了啊
                    i++;
                }


            }



        }
        return (int) res;

    }
    public static void main(String[] args){
        String s="2147483648";
//        s="-42";
        System.out.println(myAtoi(s));
        System.out.println(Integer.MIN_VALUE/10);

    }
}
