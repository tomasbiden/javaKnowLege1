package org.save1.codeSuiXiangLu.String.sisthstrStrKMP;

public class first {
    public void getNext(int[] next,String s){
        int j=-1;
        next[0]=j;
        for(int i=1;i<s.length();i++){

            while (j>0&&s.charAt(i)!=s.charAt(j+1)){
                j=next[j];
            }

            if(s.charAt(i)==s.charAt(j+1)){
//                i++;
                j++;
            }
            next[i]=j;
        }
    }
    public int strStr(String haystack,String needle){
        if(haystack.length()==0){
            return  0;
        }
        int[] next=new int[needle.length()];
        getNext(next,needle);

        int j=-1;
        for(int i=0;i<haystack.length();i++){

            while (j>0&&haystack.charAt(i)!=needle.charAt(j+1)){
                j=next[j];
            }
//          这个if语句必须放到后面才行，不然 这个if 不会再进行执行了啊
            if(haystack.charAt(i)==needle.charAt(j+1)){
                j++;
            }
//            注意这里有-1
            if(j==needle.length()-1){
                return (i-needle.length()+1);
            }
        }
        return  -1;
    }
}
