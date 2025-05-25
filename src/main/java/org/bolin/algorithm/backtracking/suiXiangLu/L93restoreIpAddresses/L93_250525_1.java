package org.bolin.algorithm.backtracking.suiXiangLu.L93restoreIpAddresses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class L93_250525_1 {

    List<String> result=new ArrayList<>();
    LinkedList<String> path=new LinkedList<>();
    public boolean check(String s,int startIndex,int endIndex){
        if(startIndex>endIndex){
            return false;
        }
        if(s.charAt(startIndex)=='0'&&startIndex!=endIndex){
            return false;
        }
        int num=0;
        for(int i=startIndex;i<=endIndex;i++){
            if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                return false;
            }
            num=num*10+s.charAt(i)-'0';
            if(num>255){
                return  false;
            }
        }
        return true;
    }
    public void backTracking(String s,int startIndex){
        if(path.size()==4||startIndex==s.length()){
            if(path.size()==4&&startIndex==s.length()){
//                注意是.而不是,啊
                String method = path.stream().collect(Collectors.joining("."));
                result.add(method);
            }else{
                return;
            }
        }
        for(int i=startIndex;i<s.length();i++){
            if(check(s,startIndex,i)){
                path.add(s.substring(startIndex,i+1));
                backTracking(s,i+1);
                path.removeLast();
            }
        }


    }
    public List<String> restoreIpAddresses(String s) {
            backTracking(s,0);
            return result;
    }
    public static void main(String[] args){
        L93_250525_1 l932505251 = new L93_250525_1();
        for (String restoreIpAddress : l932505251.restoreIpAddresses("25525511135")) {
            System.out.println(restoreIpAddress);
        }


    }
}
