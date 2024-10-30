package org.bolin.algorithm.DP.Leecode.L647countSubstrings.myself;

public class My1_241026_extend {
    int result=0;

    int mi;
    int mj;
    int tmpLen;
//    longestPalindrome
    public void judgeExtend(int i,int j,String s){
        int len=s.length();
        int ti=i;
        int tj=j;
        while (ti>=0&&tj<len&&s.charAt(ti)==s.charAt(tj)){
//         这个if要放到上面才可以的啊
            if(tmpLen<=(tj-ti+1)){
                tmpLen=tj-ti+1;
                mi=ti;
                mj=tj;
            }
            result++;
            ti--;
            tj++;



        }

    }
    public int countSubstrings(String s) {
        int len=s.length();
        for(int i=0;i<len;i++){
            judgeExtend(i,i,s);
            if(i+1<len){
                judgeExtend(i,i+1,s);
            }
        }
        String maxLenString=s.substring(mi,mj);
        return  result;
    }
}
