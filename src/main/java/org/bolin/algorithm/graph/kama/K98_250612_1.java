package org.bolin.algorithm.graph.kama;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class K98_250612_1 {
    static List<List<Integer>> result=new ArrayList<>();

    static List<Integer> path=new ArrayList<>();

    public static void dfs(int[][] grapth,int x,int n){
        if(x==n){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=1;i<=n;i++){
            if(grapth[x][i]==1){
                path.add(i);
                dfs(grapth,i,n);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] grapth=new int[n+1][n+1];

            for(int j=0;j<m;j++){
                int x=scanner.nextInt();
                int y=scanner.nextInt();
                grapth[x][y]=1;
            }
//            第1个注意不要漏掉了啊
            path.add(1);
            dfs(grapth,1,n);
//      2：注意考虑临界值啊
        if(result.isEmpty()){
            System.out.println(-1);
            return ;
        }
        for (List<Integer> integers : result) {
            String pathString = integers.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(pathString);

        }



    }
}
