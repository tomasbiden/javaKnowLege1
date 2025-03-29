package org.bolin.algorithm.String1.group1;

public class L28KMP {

    public int[] getNext(String needle){
        int[] next=new int[needle.length()];
        int j=-1;
        next[0]=-1;
        for(int i=1;i<needle.length();i++){

            while (j>=0&&needle.charAt(i)!=needle.charAt(j+1)){
                j=next[j];
            }
            if(needle.charAt(i)==needle.charAt(j+1)){
                j++;

            }
//            这里注意放到外面阿，因为这里是变成索引了阿
            next[i]=j;
        }
        return next;
    }

    public int strStr_250329_1(String haystack, String needle) {
        int[] next=getNext(needle);
        int j=-1;
        for(int i=0;i<haystack.length();i++){
            while (j>=0&&haystack.charAt(i)!=needle.charAt(j+1)){
                j=next[j];
            }
            if(haystack.charAt(i)==needle.charAt(j+1)){
                j++;
            }
            if(j==needle.length()-1){
                return i-(needle.length()-1);
            }

        }
        return  -1;
    }
}
