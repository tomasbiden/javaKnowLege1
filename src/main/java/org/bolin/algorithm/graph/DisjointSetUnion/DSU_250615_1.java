package org.bolin.algorithm.graph.DisjointSetUnion;

import java.util.Scanner;

public class DSU_250615_1 {

    static int n=1006;
//    1：注意他们是从1开始的啊
    static int[] father;

    static public void init(){
        father=new int[n+1];
        for(int i=1;i<=n;i++){
            father[i]=i;
        }
    }
    static private int find(int x){
        if(x>n){
            return  -1;
        }
        if(x==father[x]){
            return x;
        }
       return father[x]=find(father[x]);
    }

    public static int find2(int n) {
        return n == father[n] ? n : (father[n] = find(father[n]));
    }

    static public void join(int u,int v){
        int uRoot=find(u);
        int vRoot=find(v);
        if(uRoot==vRoot) return ;
//       2：不能少了root了啊
        father[vRoot]=uRoot;
    }

    static public void join2 (int n, int m) {
        n = find2(n);
        m = find2(m);
        if (n == m) return;
        father[m] = n;
    }
    static public boolean isSame(int u,int v){
        return  find(u)==find(v);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m=scanner.nextInt();
        DSU_250615_1.n=n;
        init();
//        人家是m条边，而不是m-1条边的啊
        for(int i=1;i<=m;i++){
            join(scanner.nextInt(),scanner.nextInt());
        }
        System.out.println(isSame(scanner.nextInt(), scanner.nextInt()) ?1:0);


    }
}
