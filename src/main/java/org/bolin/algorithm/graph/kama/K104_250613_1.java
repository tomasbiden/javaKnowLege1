package org.bolin.algorithm.graph.kama;

import java.util.*;

public class K104_250613_1 {
//    这里有个严重问题，你怎么能改动原来传递过来的参数呢

    static Map<Pair,Integer> pointserialNumberMap=new HashMap();

    static Map<Integer,Integer> serialNumberSizeMap=new HashMap<>();
    static int serialNumber=0;

    static int serialNumberSize=0;

    static int[][] dir=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

//    int n,int m 可以用 graph
    public static void dfs(int x,int y,int[][] graph,boolean[][] visited){
        pointserialNumberMap.put(new Pair(x,y),serialNumber);
//        注意是Size
        serialNumberSize++;
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if(checkDirValid(x,y,graph,nx,ny,visited)){
                dfs(nx,ny,graph,visited);
            }


        }
    }
    public static boolean checkDirValid(int x,int y,int[][] graph,int nx,int ny,boolean[][] visited){
//       (visited[nx][ny]) 加入，防止死循环
//        nx ny 不是 x,y
        if((nx<0||nx>=graph.length)||(ny<0||ny>=graph[0].length)||(visited[nx][ny])||(graph[nx][ny]==0)){
            return false;
        }else{
            return true;
        }
    }
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }

        // 重写 equals 方法
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true; // 同一个对象
            if (obj == null || getClass() != obj.getClass()) return false; // 空或不同类
            Pair pair = (Pair) obj;
            return x == pair.x && y == pair.y; // 比较值是否相同
        }

        // 重写 hashCode 方法
        @Override
        public int hashCode() {
            return Objects.hash(x, y); // 利用工具类自动生成 hash
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] graph=new int[n][m];
        boolean[][] leftTopArea=new boolean[n][m];
        boolean[][] rightBottom=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                graph[i][j]=scanner.nextInt();
            }
        }
        boolean[][] visited=new boolean[n][m];


        int resultMaxSie=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]==1&&!visited[i][j]){
                    serialNumber++;
                    dfs(i,j,graph,visited);
                    serialNumberSizeMap.put(serialNumber,serialNumberSize);
                    serialNumberSize=0;

                }

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]==0){
                    int tmpMaxSize=0;
                    Set<Integer> nearSet = new HashSet<>();
                    for(int k=0;k<4;k++){
//                        1:注意防止空异常   3：注意数字越界问题
                        int nearX=i+dir[k][0];
                        int nearY=j+dir[k][1];
                        if(nearX<0||nearX>=n||nearY<0||nearY>=m) continue;
                        if(graph[i+dir[k][0]][j+dir[k][1]]==1){
                            Integer i1 = pointserialNumberMap.get(new Pair(nearX, nearY));
                            nearSet.add(pointserialNumberMap.get(new Pair(i+dir[k][0],j+dir[k][1])));
                        }

                    }
                    for (Integer serialNumber : nearSet) {
                        tmpMaxSize+=serialNumberSizeMap.get(serialNumber);
                    }
//                    2：注意原本的土地也是要算的啊
                    tmpMaxSize+=1;
                    resultMaxSie=Math.max(resultMaxSie,tmpMaxSize);
                }

            }
        }
        if(resultMaxSie==0){
            System.out.println(n*m);
        }else{
            System.out.println(resultMaxSie);

        }

//     这里非常关键的啊
        scanner.close();



    }
}
