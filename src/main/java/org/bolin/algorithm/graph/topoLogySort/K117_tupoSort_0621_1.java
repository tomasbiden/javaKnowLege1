package org.bolin.algorithm.graph.topoLogySort;

import java.util.*;
import java.util.stream.Collectors;

public class K117_tupoSort_0621_1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int e=scanner.nextInt();

        int[] inDegree=new int[n+1];
        Map<Integer,List<Integer>> sourceToTargetMap=new HashMap<>();


        for(int i=1;i<=e;i++){
            int source=scanner.nextInt();
            int target=scanner.nextInt();
//            函数名字不要重复
            sourceToTargetMap.computeIfAbsent(source,key-> new ArrayList<Integer>()).add(target);
            inDegree[target]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        List<Integer> result=new ArrayList<>();
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            result.add(poll);
//           1：注意这里的空异常问题啊    2：注意是ifPresent 不是 ifPreset
            Optional.ofNullable(sourceToTargetMap.get(poll)).ifPresent(list->list.forEach(target->{
                inDegree[target]--;
                if(inDegree[target]==0){
                    queue.offer(target);
                }
            }));
        }
//        3:注意成环控制
        if(result.size()==n){
            System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }else{
            System.out.println(-1);
        }


    }
}
