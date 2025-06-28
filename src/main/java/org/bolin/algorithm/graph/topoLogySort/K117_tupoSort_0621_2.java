package org.bolin.algorithm.graph.topoLogySort;

import java.util.*;
import java.util.stream.Collectors;

public class K117_tupoSort_0621_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();

        int[] inDegree = new int[n + 1];
        List<List<Integer>> sourceToTargetMap = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sourceToTargetMap.add(new ArrayList<>());
        }


        for (int i = 1; i <= e; i++) {
            int source = scanner.nextInt();
            int target = scanner.nextInt();
//            函数名字不要重复
            sourceToTargetMap.get(source).add(target);
            inDegree[target]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result.add(poll);
//           1：注意这里的空异常问题啊    2：注意是ifPresent 不是 ifPreset
            for (int target : sourceToTargetMap.get(poll)) {
                inDegree[target]--;
                if (inDegree[target] == 0) {
                    queue.offer(target);
                }
            }
//        3:注意成环控制
            if (result.size() == n) {
                for (int i = 0; i < n; i++) {
                    System.out.print(result.get(i));
                    if (i != (n - 1)) {
                        System.out.println(" ");
                    }
                }
            } else {
                System.out.println(-1);
            }


        }
    }
}
