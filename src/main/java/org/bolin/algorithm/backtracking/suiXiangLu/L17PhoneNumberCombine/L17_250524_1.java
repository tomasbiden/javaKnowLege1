package org.bolin.algorithm.backtracking.suiXiangLu.L17PhoneNumberCombine;

import java.util.ArrayList;
import java.util.List;

public class L17_250524_1 {
    List<String> result=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public void backTracking(String[] arr,int startIndex,String digits){
            if(sb.length()==digits.length()){
                result.add(sb.toString());
                return;
            }
            String choice=arr[digits.charAt(startIndex)-'0'];
            for(int i=0;i<choice.length();i++){
                sb.append(choice.charAt(i));
                backTracking(arr,startIndex+1,digits);
                sb.deleteCharAt(sb.length()-1);
            }

    }
    public List<String> letterCombinations(String digits) {
//        2:注意空异常处理
        if(digits==null||digits.length()==0){
            return  result;
        }
//        1:有[]
        String[] arr=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backTracking(arr,0,digits);
        return result;
    }

    public static void main(String[] args){
        L17_250524_1 l172505241 = new L17_250524_1();
        for (String letterCombination : l172505241.letterCombinations("")) {
            System.out.println(letterCombination);
        }


    }

}
