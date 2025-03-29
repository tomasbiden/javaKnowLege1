package org.bolin.algorithm.String1.group1;

import java.util.Scanner;

public class K54replaceNumber {
    public void replaceNumber_250329_1(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='1'&&s.charAt(i)<='9'){
                stringBuffer.append("number");
            }else {
                stringBuffer.append(s.charAt(i));
            }
        }
        System.out.println(stringBuffer.toString());


    }
}
