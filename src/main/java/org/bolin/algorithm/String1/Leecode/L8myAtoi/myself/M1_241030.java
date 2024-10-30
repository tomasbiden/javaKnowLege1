package org.bolin.algorithm.String1.Leecode.L8myAtoi.myself;
/*
class Solution {
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
}
 */

public class M1_241030 {
    public int deleteBlank(String s,int start){
        int i=start;
//        注意不是双引号
        while (i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        return  i;

    }
    public int checkSign(String s,int start){
//        1 正  -1负号
        int sign=1;
        int len=s.length();
        if(start<len&&(s.charAt(start)=='+'||s.charAt(start)=='-')){
            return s.charAt(start)=='+'?1:-1;
        }else {
            return 1;
        }
    }
    public int myAtoi(String s) {
        int len=s.length();
        int bN=deleteBlank(s,0);
        int curIndex=bN;
        int sign=checkSign(s,bN);
        int num=0;
        if(curIndex<len&&(s.charAt(curIndex)=='+'||s.charAt(curIndex)=='-')){
            curIndex++;
        }
//        注意要去掉前导0啊
        while (curIndex<len&&s.charAt(curIndex)=='0'){
            curIndex++;
        }
        while (curIndex<len){

            if(s.charAt(curIndex)>'9'||s.charAt(curIndex)<'0'){
//                不要漏掉 *sign
//                return num*sign;
//                直接break也是可以的啊
                break;
            }
            int y=s.charAt(curIndex)-'0';
            int iMax=Integer.MAX_VALUE;
//            是Min不是Max
            int iMin=Integer.MIN_VALUE;
            if(sign==1&&num>(iMax-y)/10){
                return  iMax;
            }
//            这里是 +y的啊
            if(sign==-1&&sign*num<(iMin+y)/10){
                System.out.println(Integer.MIN_VALUE-y);
//                System.out.println(sign*num+" "+(iMin-y)+""+ (iMin-y)/10);
                return  iMin;
            }
            curIndex++;
            num=num*10+y;

        }



        return  sign*num;



    }
    public  static void main(String [] args){
        String str="  -0012a42";
        M1_241030 m1241030 = new M1_241030();
//        m1241030.myAtoi(str);
        System.out.println(Integer.MIN_VALUE+" "+Integer.MAX_VALUE);

    }

}
