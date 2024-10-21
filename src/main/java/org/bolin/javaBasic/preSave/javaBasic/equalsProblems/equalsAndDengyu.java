package org.bolin.javaBasic.preSave.javaBasic.equalsProblems;

public class equalsAndDengyu {

    public  static  void main(String[] args){


        //          == and equals difference
        /*

                  String s1=new String("abc");
                  String s2=new String("bcd");
                  String s3=s1;
                  System.out.println(s1.hashCode()+" "+s3.hashCode());
                  equalsAndDengyu e1 = new equalsAndDengyu();
                  equalsAndDengyu e2=e1;
                  System.out.println(e1.hashCode()+" "+e2.hashCode());
                  System.out.println(e1.equals(e2));
                  System.out.println(s1.equals(s2));
        */


//      String 字符串的常用方法

        String s1=new String("1s2s3s4ss55s66s");
        String substring = s1.substring(2);
//        s1.length();
//        s1.isEmpty();
//        s1.charAt(1);
//        s1.indexOf();
        String[] s = s1.split("s");
        for (String string : s) {
            System.out.println(string);

        }

//        System.out.println(substring);





    }

}
