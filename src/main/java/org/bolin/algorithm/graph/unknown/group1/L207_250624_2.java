package org.bolin.algorithm.graph.unknown.group1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L207_250624_2 {


    public boolean canFinish(int numCourses, int[][] prerequisites) {

//        注意空处理
        if(prerequisites==null||prerequisites.length==0){
//           注意这里是 true;
            return  true;
        }
        List<List<Integer>>  sourceToMap=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            sourceToMap.add(new ArrayList<>());
        }
        int hasStudy=0;

        int[] inDegree=new int[numCourses];
        for(int i=0;i< prerequisites.length;i++){
            int source=prerequisites[i][0];
            int to=prerequisites[i][1];
            inDegree[to]++;
//           注意这里不能漏了啊
            sourceToMap.get(source).add(to);
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i< inDegree.length;i++){
            if(inDegree[i]==0){
                queue.offer(i);
//               这里重复了啊
//                hasStudy++;
            }
        }
        while (!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                Integer poll = queue.poll();
//                这句不要也行的
//                inDegree[poll]--;
                hasStudy++;

                List<Integer> toList=sourceToMap.get(poll);
                for(Integer to : toList){
                    inDegree[to]--;
                    if(inDegree[to]==0){
                        queue.offer(to);
                    }
                }
            }
        }
        return  hasStudy==numCourses;


    }
    public static void main(String[] args){
        int numCourses=3;
        int[][] grid=new int[][]{{1,0}};
        L207_250624_2 l2072506242 = new L207_250624_2();
        boolean b = l2072506242.canFinish(numCourses, grid);
        System.out.println(b);


    }
}
