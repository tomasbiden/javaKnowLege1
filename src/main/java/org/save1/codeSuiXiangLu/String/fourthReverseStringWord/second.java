package org.save1.codeSuiXiangLu.String.fourthReverseStringWord;

public class second {


//    这个方法自己想的，没有教程的好用
    public String reverseWords(String s) {
//        String[] split = s.split("\n");
        StringBuffer res=new StringBuffer();
        for(int i=s.length()-1;i>=0;i--){
            StringBuffer tmpString = new StringBuffer();
            while (i>=0&&s.charAt(i)!=' '){

                tmpString.append(s.charAt(i));
                i--;


            }
//            将二者进行捆绑才是一个比较好的解决方法
            if(tmpString.length()>0){
                res.append(tmpString.reverse());
                res.append(" ");
            }

//            必须确保开头不能为空格
            /*
            这个代码有 数据越界问题
            if(res.charAt(0)!=' '){
                res.append(" ");
            }

             */

            if(res.length()>0){
                res.append(" ");
            }



//            置为空的是放在下面的啊
            tmpString=new StringBuffer("");

        }
        res.deleteCharAt(res.length()-1);
        return  res.toString();


    }
}
