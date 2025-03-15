package org.bolin.byteDance;

public class P103 {
    public static Boolean judgePerfect(int x){
        if(x%10==0){
            return false;
        }else {
            int first=x%10;
            while (x!=0){

                if(x%10!=first){
                    return false;
                }
                x/=10;
            }
        }
        return true;
    }
    public static int solution(int x, int y) {
        // Edit your code here
        int result=0;
       for(int i=x;i<=y;i++){
           result+=(judgePerfect(i)==true?1:0);
       }
       return  result;
    }
    public static void main(String[] args){
        int solution = solution(1, 10);
        System.out.println(solution(1, 10) == 9);
    }
}
