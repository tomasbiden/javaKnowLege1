package org.bolin.algorithm.backtracking.suiXiangLu.L17PhoneNumberCombine;

import java.util.ArrayList;
import java.util.List;

class  L17letterCombinations_2500719_1{
    private final String[] indexStringMapping=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        int[] arr=new int[2];
        int length = arr.length;
//       注意string 是成员遍历的啊
        if(digits.length()==0){
            return new ArrayList<>();
        }
        List<String> result=new ArrayList<>();
        dfs(digits,0,new StringBuilder(),result);
        return result;
    }

    private void dfs(String digits,int index,StringBuilder sb,List<String> result){

        if(index>=digits.length()){
            result.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        int num=c-'0';
        String choices=indexStringMapping[num];
        for(int i=0;i<choices.length();i++){
            sb.append(choices.charAt(i));
            dfs(digits,index+1,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }


    }

}
public class L17letterCombinations {



}
