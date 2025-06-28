package org.bolin.algorithm.realQuestion.jingDong.jd0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class K260_25622_2 {
    static int[][] map=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String next = br.readLine();
        int x=0;
        int y=0;

        int tmpDir=0;
        for(int i=0;i<next.length();i++){
            char c = next.charAt(i);
            switch (c){
                case 'W':
                    x+=map[tmpDir][0];
                    y+=map[tmpDir][1];
                    break;
                case 'A':
                    tmpDir=(tmpDir-1+4)%4;
                    break;
                case 'D':
                    tmpDir=(tmpDir+1+4)%4;
                    break;
            }


        }
        System.out.println(x+" "+y);



    }
}
