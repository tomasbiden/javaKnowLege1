package org.bolin.algorithm.String1.group1;

public class L541reverseStr {
    public void  reverseMethod(int startIndex,int endIndex,int length,int k,StringBuilder stringBuilder,String s){
        int reverseStart=startIndex;
        int reverseEnd;
        if(startIndex+(k-1)<=endIndex){
            reverseEnd=startIndex+(k-1);
        }else {
            reverseEnd=endIndex;
        }
//        reverseEnd>=reverseStart 错误
        for(int i=reverseEnd;i>=reverseStart;i--){
            stringBuilder.append(s.charAt(i));
        }
        int commonIndex=reverseEnd+1;
        while (commonIndex<=endIndex){
            stringBuilder.append(s.charAt(commonIndex));
            commonIndex++;
        }
    }

    public String reverseStr(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
//        注意是2k 而不是k啊
        int count=s.length()/(2*k);
        if(!(s.length()%(2*k)==0)){
            count++;
        }
        for(int i=1;i<=count;i++){
//            注意是 2*k啊
            int startIndex=(i-1)*2*k;
//            i*k-1 错误
            int endIndex=i*2*k-1;
            endIndex=Math.min(endIndex,s.length()-1);
            reverseMethod(startIndex,endIndex,s.length(),k,stringBuilder,s);
        }
        return  stringBuilder.toString();
    }
}
