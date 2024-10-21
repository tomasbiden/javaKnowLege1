package org.bolin.javaBasic.preSave.javaBasic;

public class StringBufferStringBuilderString {
    public  static  void main(String[] args){
        String s1="sdfsdf";
        String s2=new String("sdfsddsfs");
        StringBuffer sB=new StringBuffer("sdfsdfsdfsdfsdf");
        sB.append("sdfsdf1");
        /*
        StringBuffer  添加了Synchronized 的关键字
         */
        System.out.println(sB);

        StringBuilder sBuilder=new StringBuilder("BUildersdfsdfs");
        sBuilder.append("236523");
        System.out.println(sBuilder);




    }
}
