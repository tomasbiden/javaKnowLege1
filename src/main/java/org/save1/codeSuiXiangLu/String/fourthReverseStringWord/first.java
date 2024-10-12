package org.save1.codeSuiXiangLu.String.fourthReverseStringWord;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class first {
//    这个方法用处不大
    public String reverseWords(String s) {
//        String[] split = s.split("\n");

        String[] s1 = s.trim().split(" ");
        List<String> list = Arrays.asList(s1);
        Collections.reverse(list);
      return   String.join(" ",list);



    }
}
