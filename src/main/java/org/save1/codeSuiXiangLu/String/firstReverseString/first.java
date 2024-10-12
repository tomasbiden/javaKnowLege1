package org.save1.codeSuiXiangLu.String.firstReverseString;

public class first {
    public static void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while (i<j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
