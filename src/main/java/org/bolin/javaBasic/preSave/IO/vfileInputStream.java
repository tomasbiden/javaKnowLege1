package org.bolin.javaBasic.preSave.IO;



import java.io.*;

public class vfileInputStream {

    public  static void byprint(byte[] by){

        for(int i=0;i<by.length;i++){

            System.out.println((char)by[i]);
        }

    }
    public static void tFileInputStream() throws IOException{
        System.out.println("now is testing tFileInputStream");
        FileInputStream fileInputStream = new FileInputStream("D:\\weizuomian\\JAVA\\study\\v1\\src\\main\\java\\org\\example\\IO\\resource\\word.txt");

        int read =  fileInputStream.read();
        System.out.println((char) read);
        byte[] by=new byte[4];
        fileInputStream.read(by);
        byprint(by);


        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//        String s = new String(bufferedInputStream.readAllBytes());
//        System.out.println(s);

    }
    public static void tFileReader() throws IOException {
        System.out.println("tFileReader");
        FileReader fileReader = new FileReader("D:\\weizuomian\\JAVA\\study\\v1\\src\\main\\java\\org\\example\\IO\\resource\\char.txt");
        int content;
        while ((content=fileReader.read())!=-1){
            System.out.print((char)content+" ");

        }

        /*
        BufferedReader
         */

    }
    public static void main(String[] args) throws IOException {
        tFileInputStream();
        tFileReader();


    }

}