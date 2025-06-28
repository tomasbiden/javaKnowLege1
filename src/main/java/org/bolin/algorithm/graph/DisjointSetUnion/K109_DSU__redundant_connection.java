package org.bolin.algorithm.graph.DisjointSetUnion;

import java.util.*;

public class K109_DSU__redundant_connection {

    static class Edge{
        int s;
        int t;
        public Edge(int s,int t){
            this.s=s;
            this.t=t;
        }
    }
     static class Dsu{

        int[] father;
        public Dsu(int n){
            father=new int[n+1];
            for(int i=1;i<=n;i++){
                father[i]=i;
            }


        }
        private int find(int x){
            if(father[x]==x){
                return x;
            }
            return  father[x]=find(father[x]);
        }

        public boolean join(int u,int v){
            int uRoot=find(u);
            int vRoot=find(v);
            if(uRoot==vRoot){
                return  false;
            }
            father[uRoot]=vRoot;
            return true;
        }

    }

    public static boolean isTreeAfterExclude(List<Edge> edges,Edge excludeEdge){
        Dsu dsu = new Dsu(edges.size()+1);
        for( Edge edge : edges){
            if(edge==excludeEdge){
                continue;
            }
            if(!dsu.join(edge.s,edge.t)){
                return false;
            }
        }
        return  true;

    }
    public static Edge getRemoveEdge(List<Edge> edges){
        Dsu dsu = new Dsu(edges.size()+1);
        for(Edge edge : edges ){
            if(!dsu.join(edge.s,edge.t)){
                return edge;
            }
        }
        return new Edge(-1,-1);

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,Integer> inDegree=new HashMap<>(n);
        List<Edge> edges=new ArrayList<>();
        Edge resultEdge=null;
        for(int i=1;i<=n;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            edges.add(new Edge(u,v));
            Integer i1 = inDegree.get(v);
            inDegree.put(v,i1==null?1:i1+1);
//            注意空异常
            if(i1!=null&&i1==1){
                List<Edge> nearEdges=new ArrayList<>();
                for(int j=0;j<edges.size();j++){
                    if(edges.get(j).t==v){
                        nearEdges.add(edges.get(j));
                    }
                }
                if(isTreeAfterExclude(edges,nearEdges.get(1))){
                    resultEdge=nearEdges.get(1);
                }else{
                    resultEdge=nearEdges.get(0);
                }

            }

        }
        if(resultEdge == null){
            resultEdge=getRemoveEdge(edges);
        }
        System.out.println(resultEdge.s+" "+resultEdge.t);


    }
}
