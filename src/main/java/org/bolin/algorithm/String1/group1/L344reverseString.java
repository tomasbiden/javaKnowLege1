package org.bolin.algorithm.String1.group1;

public class L344reverseString {

    public void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while (i<j){
            char tmp=s[i];
            s[i]=s[j];
            s[j]=tmp;
            i++;
            j--;
        }
    }
}
