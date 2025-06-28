package org.bolin.algorithm.graph.DisjointSetUnion.L685_findRedundantDirectedConnection;

import java.util.*;

public class L685_DSU__redundant_connection {

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
    public int[] findRedundantDirectedConnection(int[][] edges2) {

        int n=edges2.length;
        Map<Integer,Integer> inDegree=new HashMap<>(n);
        List<Edge> edges=new ArrayList<>();
        Edge resultEdge=null;
        List<Edge> nearEdges=new ArrayList<>();
        for(int i=0;i<n;i++){
            int u=edges2[i][0];
            int v=edges2[i][1];
            edges.add(new Edge(u,v));
            Integer i1 = inDegree.get(v);
            inDegree.put(v,i1==null?1:i1+1);
//            1:注意空异常
            if(i1!=null&&i1==1){

                for(int j=0;j<edges.size();j++){
                    if(edges.get(j).t==v){
                        nearEdges.add(edges.get(j));
                    }
                }
//           2:判断不能放里面，因为这时edges没有填充完毕
//                if(isTreeAfterExclude(edges,nearEdges.get(1))){
//                    resultEdge=nearEdges.get(1);
//                }else{
//                    resultEdge=nearEdges.get(0);
//                }

            }

        }
        if(nearEdges.size()>0){
            if(isTreeAfterExclude(edges,nearEdges.get(1))){
                resultEdge=nearEdges.get(1);
            }else{
                resultEdge=nearEdges.get(0);
            }

        }
        if(resultEdge == null){
            resultEdge=getRemoveEdge(edges);
        }
        System.out.println(resultEdge.s+" "+resultEdge.t);

        int[] result=new int[2];
        result[0]= resultEdge.s;
        result[1]= resultEdge.t;
        return result;

    }
    public static void main(String[] args){

        L685_DSU__redundant_connection l685Dsu__redundantConnection = new L685_DSU__redundant_connection();
        int[][] edges=new int[][]{{2,1},{3,1},{4,2},{1,4}};
        l685Dsu__redundantConnection.findRedundantDirectedConnection(edges);

    }
}
