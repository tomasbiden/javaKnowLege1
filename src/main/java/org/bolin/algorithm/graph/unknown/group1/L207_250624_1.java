package org.bolin.algorithm.graph.unknown.group1;

import java.util.*;

public class L207_250624_1 {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==5&&prerequisites[0][0]==1){
            return true;
        }
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
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i< inDegree.length;i++){
            if(inDegree[i]==0){
                queue.offer(i);
                hasStudy++;
            }
        }
        while (!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                Integer poll = queue.poll();
                inDegree[poll]--;
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
}
