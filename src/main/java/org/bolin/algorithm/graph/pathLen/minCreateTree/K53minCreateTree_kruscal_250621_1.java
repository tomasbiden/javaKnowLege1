package org.bolin.algorithm.graph.pathLen.minCreateTree;

import java.util.*;

public class K53minCreateTree_kruscal_250621_1 {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int vSize=scanner.nextInt();
        int eSize=scanner.nextInt();
        List<Edge> edges=new ArrayList<>();
        for(int i=1;i<=eSize;i++){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            int z=scanner.nextInt();
            edges.add(new Edge(x,y,z));

        }
        DisjoinSet disjoinSet = new DisjoinSet(vSize);
        int result=0;
//       1：这里注意学习一下
        edges.sort(Comparator.comparingInt(edge->edge.val));
        for( Edge edge : edges){
            if(disjoinSet.join(edge.x,edge.y)){
                result+=edge.val;
            }
        }
        System.out.println(result);


    }
    public static class Edge{
        int x;
        int y;

        int val;
        public Edge(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }

    public  static class DisjoinSet{

        int[] father;
        public  DisjoinSet(int vSize){

            father=new int[vSize+1];
            for(int i=0;i<vSize;i++){
                father[i]=i;
            }
        }

        private int find(int u){
            if(father[u]==u){
                return  u;
            }
            return father[u]=find(father[u]);
        }
        private boolean join(int u,int v){
            int uRoot=find(u);
            int vRoot=find(v);
            if(uRoot==vRoot){
                return false;
            }
            father[uRoot]=v;
            return true;
        }

    }
}
