package org.bolin.algorithm.doublePointer.Leecode.L3lengthOfLongestSubstring;

import java.util.HashMap;

public class My1_241030_movingWindows {
//    3
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        int res=0;
        int len=s.length();
        int i=0; int j=0;
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
//        不要忘记将0放进去了啊
        characterIntegerHashMap.put(s.charAt(0),0);
//        j要从0开始啊  ,应该用while而不应该用for
       while (i<=j){
           while (j+1<len&&!characterIntegerHashMap.containsKey(s.charAt(j+1))){
               characterIntegerHashMap.put(s.charAt(j+1),++j);


           }
           res=Math.max(res,j-i+1);
           if(j+1==len){
               break;
           }else {
//                characterIntegerHashMap.remove(s.charAt(i));  这个操作时错误的，应该进行跳跃才对的啊
               int position=characterIntegerHashMap.get(s.charAt(j+1));

               for(i=i;i<=position;i++){
                   characterIntegerHashMap.remove(s.charAt(i));
               }
               if(j<i){
                   j=i;
                   characterIntegerHashMap.put(s.charAt(i),i);
               }



//                   这里在探讨有必要将j+1的 char作为 key放进去吗，我感觉时不需要的
           }
       }

        return  res;
       }

    public int lengthOfLongestSubstring2(String s) {
        if(s.length()<=1){
            return s.length();
        }
        int res=0;
        int len=s.length();
        int i=0; int j=0;
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
//        不要忘记将0放进去了啊
        characterIntegerHashMap.put(s.charAt(0),0);
//        j要从0开始啊  ,应该用while而不应该用for
//        这里不用 i<=j
        while (true){
            while (j+1<len&&!characterIntegerHashMap.containsKey(s.charAt(j+1))){
                characterIntegerHashMap.put(s.charAt(j+1),++j);


            }
            res=Math.max(res,j-i+1);
            if(j+1==len){
                break;
            }else {
//                characterIntegerHashMap.remove(s.charAt(i));  这个操作时错误的，应该进行跳跃才对的啊
                int position=characterIntegerHashMap.get(s.charAt(j+1));

                for(i=i;i<=position;i++){
                    characterIntegerHashMap.remove(s.charAt(i));
                }
                /*
                if(j<i){
                    j=i;
                    characterIntegerHashMap.put(s.charAt(i),i);
                }

                 */



//                   这里在探讨有必要将j+1的 char作为 key放进去吗，我感觉时不需要的
            }
        }

        return  res;
    }


    public int lengthOfLongestSubstring_excellent(String s) {
        if(s.length()<=1){
            return s.length();
        }
        int res=0;
        int len=s.length();
        int i=0; int j=0;
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        characterIntegerHashMap.put(s.charAt(0),0);
        for(i=0;i<len;i++){
            while (j+1<len&&!characterIntegerHashMap.containsKey(s.charAt(j+1))){
                characterIntegerHashMap.put(s.charAt(j+1),++j);

            }
            res=Math.max(res,j-i+1);

            characterIntegerHashMap.remove(s.charAt(i));
        }
        return res;
    }




    public static  void main(String[] args){
        My1_241030_movingWindows my1241030MovingWindows = new My1_241030_movingWindows();
        int i=my1241030MovingWindows.lengthOfLongestSubstring2("aab");
        System.out.println(i);


    }

}
