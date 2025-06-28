package org.bolin.algorithm.graph.dijkstra.heap;

import java.util.*;

class Edge{
    int to;
    int val;
    public Edge(int to,int val){
        this.to=to;
        this.val=val;
    }
}
 class Pair<U,V>{
    U first;
    V second;
    public Pair(U u,V v){
        this.first=u;
        this.second=v;
    }
}
class MyCompare implements Comparator<Pair<Integer,Integer>>{

    @Override
    public int compare (Pair<Integer,Integer> o1,Pair<Integer,Integer> o2){
        return Integer.compare(o1.second,o2.second);
    }


}
public class K47_heap_250622_1 {







    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int e=scanner.nextInt();

        List<List<Edge>>  graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
//       2:  i<n 错误
        for(int i=1;i<=e;i++){
            graph.get(scanner.nextInt()).add(new Edge(scanner.nextInt(),scanner.nextInt()));
        }
        int[] minDist=new int[n+1];


        boolean[] visited=new boolean[n+1];
        Arrays.fill(minDist,Integer.MAX_VALUE);
        //       注意初始化啊
        minDist[1]=0;
//
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new MyCompare());
        pq.offer(new Pair<Integer,Integer>(1,0));
        while (!pq.isEmpty()){
            Pair<Integer,Integer> cur=pq.poll();
            visited[cur.first]=true;
//            1: =0 错误
            List<Edge> edges = graph.get(cur.first);
            for(Edge edge :edges){
                if(!visited[edge.to]&&minDist[edge.to]>minDist[cur.first]+edge.val){
                    minDist[edge.to]=minDist[cur.first]+edge.val;
                    pq.offer(new Pair<>(edge.to,minDist[edge.to]));
                }
            }
        }
        System.out.println(minDist[n]==Integer.MAX_VALUE?-1:minDist[n]);


    }
}
