package org.bolin.javaBasic.preSave.linshi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class first {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\word.txt");
        char read = (char) fileInputStream.read();
        System.out.println(read);
        String x="sdfsd";
//        x.equalsIgnoreCase();
    }
}
