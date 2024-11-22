package org.bolin.algorithm.String1.Leecode.L151reverseWords.myself;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
class Solution {
    public String reverseWords(String s) {
                StringBuffer res=new StringBuffer();
        for(int i=s.length()-1;i>=0;i--){
            StringBuffer tmpString = new StringBuffer();
            while (i>=0&&s.charAt(i)!=' '){

                tmpString.append(s.charAt(i));
                i--;

            }

                   if(tmpString.length()>0){
                res.append(tmpString.reverse());
                res.append(" ");
            }

             tmpString=new StringBuffer("");

        }
        res.deleteCharAt(res.length()-1);
        return  res.toString();


    }
}
 */
public class My1_241106 {

    public String reverseWords2(String s) {

        int i=0;
        int j=s.length()-1;
        ArrayList<String> strings = new ArrayList<>();
        while (i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        while (j>=0&&s.charAt(j)==' '){
            j--;
        }

        for(int k=i;k<=j;k++){
            String tmpS=new String();
//            又是数据越界问题啊
            while (k<=j&&s.charAt(k)!=' '){
                tmpS+=s.charAt(k);
//                不能漏掉了啊
                k++;
            }
            if(tmpS.length()>0){
                strings.add(tmpS);
            }
        }
        int listSize=strings.size();
        String res=new String();
        for(i=listSize-1;i>=0;i--){
           res+=strings.get(i);
           if(i!=0){
               res+=' ';
           }

        }



        return  res;
    }

    public String reverseWords3(String s) {

        int i=0;
        int j=s.length()-1;

        while (i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        while (j>=0&&s.charAt(j)==' '){
            j--;
        }
        StringBuffer res=new StringBuffer();
        for(int k=j;k>=i;k--){
            StringBuffer stringBuffer = new StringBuffer();
//            又是数据越界问题啊
            while (k>=i&&s.charAt(k)!=' '){
                stringBuffer.append(s.charAt(k));
                k--;
//                不能漏掉了啊

            }
            res.append(stringBuffer.reverse().toString());
//            注意判断只能加一个空格，且最后一个string不能加空格
            if(k>=i&&res.charAt(res.length()-1)!=' '){
                res.append(' ');
            }

        }
        
        return  res.toString();
    }
    public  StringBuilder removeSpace(String s){
        int i=0;
        int j=s.length()-1;

        while (i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        while (j>=0&&s.charAt(j)==' '){
            j--;
        }
        StringBuilder formatString=new StringBuilder();
        for(int k=i;k<=j;k++){
//            右边s.charAt错误
            if(s.charAt(k)!=' '||formatString.charAt(formatString.length()-1)!=' '){
                formatString.append(s.charAt(k));
            }
        }

        return  formatString;

    }
    public static void reverseString(StringBuilder stringBuilder, int start,int end){
        int i=start;
        int j=end;
        while (i<j){
            char tmp=stringBuilder.charAt(i);
            stringBuilder.setCharAt(i,stringBuilder.charAt(j));
            stringBuilder.setCharAt(j,tmp);

            i++;
            j--;
//            迭代不能漏掉了啊

        }

    }


    public String reverseWords(String s) {


        StringBuilder stringBuilder = removeSpace(s);
        reverseString(stringBuilder, 0, stringBuilder.length() - 1);
        int len=stringBuilder.length();
        int start=0;
        int end=0;
        while (end<len){
            while (end<len&&stringBuilder.charAt(end)!=' '){
                end++;
            }
            reverseString(stringBuilder,start,end-1);

            start=end+1;
            end=start;


        }





        return stringBuilder.toString();
    }
    public static void main(String[] args){
        My1_241106 my1241106 = new My1_241106();
        String theSkyIsBlue = my1241106.reverseWords("the sky is blue");
        System.out.println(theSkyIsBlue);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
//        List<Integer> collect = list.stream().collect(Collectors.joining(","));

        String s = new String();

//        System.out.println(collect);

    }
}
