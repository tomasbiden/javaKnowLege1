package org.bolin.algorithm.graph.DisjointSetUnion;

import java.util.Scanner;

public class K108_DSU__redundant_connection {

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



    static boolean  join(int u,int v){
        int uRoot=find(u);
        int vRoot=find(v);
        if(uRoot==vRoot) return false ;
//       2：不能少了root了啊
        father[vRoot]=uRoot;
        return true;
    }


    static public boolean isSame(int u,int v){
        return  find(u)==find(v);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        K108_DSU__redundant_connection.n=n;
        init();
//        人家是m条边，而不是m-1条边的啊
        for(int i=1;i<=n;i++){
            int u=scanner.nextInt();
            int v=scanner.nextInt();
            if(!join(u,v)){
                System.out.println(u+" "+v);
            }

        }
    }
}
