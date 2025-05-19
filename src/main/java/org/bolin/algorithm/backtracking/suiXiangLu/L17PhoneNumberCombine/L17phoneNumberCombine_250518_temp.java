package org.bolin.algorithm.backtracking.suiXiangLu.L17PhoneNumberCombine;

import jodd.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class L17phoneNumberCombine_250518_temp {

//    注意下string数组的定义方法，数组直接用大括号定义即可，
    String[] numberLetterMap={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    List<String> result=new ArrayList<>();

    StringBuilder path=new StringBuilder();


    public void backTracking(int startIndex,int[] arr ){
        if(startIndex==arr.length){
            result.add(path.toString());
             return;
        }
        for(int i=0;i<numberLetterMap[arr[startIndex]].length();i++){
            path.append(numberLetterMap[arr[startIndex]].charAt(i));
            backTracking(startIndex+1,arr);
            path.deleteCharAt(path.length()-1);
        }

    }

//    2：定义combine函数
    public List<String> combine(String digits) {
//    3：数组初始化
        int[] arr=new int[digits.length()];
        for(int i=0;i<digits.length();i++){
//            arr[i]=Integer.valueOf(digits.charAt(i));  ascii 码
            arr[i]=digits.charAt(i)-'0';
        }

        backTracking(0,arr);
        return  result;


    }
    public static void main(String[] args){

        L17phoneNumberCombine_250518_temp l77ZuHe250518Temp = new L17phoneNumberCombine_250518_temp();
        List<String> combine = l77ZuHe250518Temp.combine("2");
        int h=1;

    }
}
