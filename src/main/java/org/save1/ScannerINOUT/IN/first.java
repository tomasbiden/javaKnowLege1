package org.save1.ScannerINOUT.IN;

import java.util.ArrayList;
import java.util.Scanner;

public class first {
    public static void s1(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()){
            if(scanner.nextInt()==-1){
                break;
            }
            list.add(scanner.nextInt());
        }

        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        char[] str1={'a','2','3','4','5'};
        for (char c : str1) {
            System.out.print(c+" ");

        }
        System.out.print(array.toString());

    }

    public static void main(String[] args){
        s1();

    }
}
