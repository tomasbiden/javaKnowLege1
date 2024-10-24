package org.bolin.algorithm.graph.Leecode.L200numIslands.myself;



import jodd.util.ArraysUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class tmp {
    //      6
    boolean[][] used;
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void dfs(char[][] grid, int x, int y, int xLen, int yLen) {
        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
//            越界判断的要先放到前面的啊  ， 是 nx 而不少 x啊        used[nx][ny] 错误
            if (nx >= xLen || nx < 0 || ny >= yLen || ny < 0 || grid[nx][ny] == '0' || used[nx][ny]) {

            } else {
                used[nx][ny] = true;
                dfs(grid, nx, ny, xLen, yLen);
            }
        }


    }

    public int numIslands(char[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        int num = 0;
        used = new boolean[xLen][yLen];

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
//  等于 0是海洋才对的啊   注意 char 与 int的区别啊
                if (used[i][j] || grid[i][j] =='0' ) {

                } else {
                    num++;
                    used[i][j] = true;
                    dfs(grid, i, j, xLen, yLen);
                }
            }
        }
        return num;

    }

    public static void main(String[] args) {

        char[][] chars = {
                {'1', '1', '1', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        tmp my1241024 = new tmp();

    /*
        ArrayList<Integer> list = new ArrayList<>();
        list.stream();



        Scanner sc=new Scanner(System.in);
        int  x=sc.nextInt();
        int y=sc.nextInt();
        sc.nextLine();
        char[][] chars2=new char[x][y];
        for(int i=0;i<x;i++){

     */
            /*
            String sLine = sc.nextLine();
          Arrays.stream(sLine.split(" ")).map(string->{string.charAt(0);}).collect(Collectors.toList());


             */
        /*
            String sLine = sc.nextLine();
            String[] s = sLine.split(" ");
            for(int j=0;j<y;j++){
                chars2[i][j]=s[j].charAt(0);

            }

         */


        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        List<Object> collect = list.stream().map(x -> {
            return x - 1;
        }).collect(Collectors.toList());

//        左边不用括号， 右边有括号就不用return 有 大括号就需要return
        List<Object> collect2 = list.stream().map(x -> (x-1)).collect(Collectors.toList());
        int[] dp=new int[5];
        int[] array = Arrays.stream(dp).map(x -> (x + 1)).toArray();



        int sum = Arrays.stream(dp).sum();



        String string = Arrays.toString(dp);

        String string1 = dp.toString();

        System.out.println(string+" " +string1);


        List<Integer> list1 = Arrays.asList(1, 2, 3);



        int[] dp2=new int[2];
        dp2[0]=1; dp2[1]=3;

//        这三句代码最为关键的啊
        IntStream stream = Arrays.stream(dp2);
        Stream<Integer> boxed = stream.boxed();
        IntStream intStream = boxed.mapToInt(Integer::intValue);



        List<Integer> list2 = Arrays.stream(dp2).boxed().collect(Collectors.toList());

        Stream<Integer> stream1 = list2.stream();
        stream1.collect(Collectors.toList());

        Integer[] array1 = list2.toArray(new Integer[0]);
        Stream<Integer> stream2 = list2.stream();

        int[] array2 = Arrays.stream(array1).mapToInt(Integer::intValue).toArray();

        int[] newArray=new int[2];
        List<Integer> newList = Arrays.stream(newArray).boxed().map(x->(x+1)).collect(Collectors.toList());
        System.out.println(newList);
        int[] newArray2 = newList.stream().mapToInt(Integer::intValue).map(x->(x+3)).toArray();


//
        String string2 = Arrays.toString(newArray);
        System.out.println(string2);



    }
}

