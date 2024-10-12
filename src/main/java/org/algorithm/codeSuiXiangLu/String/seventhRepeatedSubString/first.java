package org.algorithm.codeSuiXiangLu.String.seventhRepeatedSubString;

public class first {
    public void getNext(int[] next,String s){
        int j=-1;
        next[0]=j;
        for(int i=1;i<s.length();i++){
            while (j>0&&s.charAt(i)!=s.charAt(j+1)){
                j=next[j];
            }
            if(s.charAt(i)==s.charAt(j+1)){
                j++;
            }
            next[i]=j;
        }
    }
    public  boolean repeatedSubstringPattern(String s){
        int[] next=new int[s.length()];
        getNext(next,s);
        int len=s.length();
//        这里一定要等于0 ，如 bb next[1]=0
        if(next[len-1]>=0&&len%(s.length()-(next[s.length()-1]+1))==0){
            return  true;

        }else {
            return  false;
        }

    }
}
