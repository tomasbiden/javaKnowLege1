package org.bolin.algorithm.String1.group1;

public class L459repeatedSubstringPattern {
    public int[] getNext(String s){
        int j=-1;
        int[] next=new int[s.length()];
        next[0]=-1;
        for(int i=1;i<s.length();i++){
            while (j>=0&&s.charAt(i)!=s.charAt(j+1)){
                j=next[j];
            }
//            复制后 !=错误
            if(s.charAt(i)==s.charAt(j+1)){
                j++;
            }
            next[i]=j;
        }
        return  next;
    }

    public boolean repeatedSubstringPattern_250329(String s) {
        int[] next = getNext(s);
//      不是所有的最大值，而是最全字符串的最长前后缀
        int yuSize=s.length()-(next[s.length()-1]+1);
        if(yuSize!=s.length()&&s.length()%yuSize==0){
            return  true;
        }else {
            return  false;
        }


    }
}
