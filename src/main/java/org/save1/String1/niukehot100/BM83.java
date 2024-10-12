package org.save1.String1.niukehot100;

public class BM83 {
    public  static void main(String[] args){
//        int kong=(int)'c';
        char c = ' ';
        int kong=(int)c;
//        System.out.println(kong);
        String initialStr=new String(" f");
        String s=initialStr;
        StringBuilder stringBuilder = new StringBuilder();
        String[] strSplict = initialStr.split(" ");
        System.out.println(strSplict.length);
        if(s.charAt(s.length()-1)==' '){
            stringBuilder.append(' ');

        }
        int c0='0';
        int cA='A';
        int ca='a';
//        System.out.println(c0+" " +cA+" "+ca);
        for(int i=strSplict.length-1;i>=0;i--){
            String strAlone=strSplict[i];
            for(int j=0;j<strAlone.length();j++){
                char x=strAlone.charAt(j);
                if(x>=97){
                    x-=32;
                }else {
                    x+=32;
                }
                stringBuilder.append(x);



            }

            stringBuilder.append(' ');

            if(i==0){
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }

        }
        if(s.charAt(0)==' '){
//            stringBuilder.append(' ');
        }
        String stringBuilderString = stringBuilder.toString();

        if(s.equals("h i ")){

        }
       System.out.println((int)stringBuilderString.charAt(1));



    }
}
