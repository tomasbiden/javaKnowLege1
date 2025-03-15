package org.bolin.byteDance;

import java.util.*;
import java.util.stream.Collectors;

public class P49_1 {
    public static List<String> solution(int n, List<String> s, List<Integer> x) {
        // 将姓名和金额组合成一个列表，每个元素是一个Map.Entry类型，保存姓名和金额
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new AbstractMap.SimpleEntry<>(s.get(i), x.get(i)));
        }

        // 使用Stream排序：根据金额降序排序，如果金额相同则按照原始顺序排序
        return list.stream()
                .sorted((entry1, entry2) -> {
                    // 先按金额降序排序
                    int amountComparison = Integer.compare(entry2.getValue(), entry1.getValue());
                    if (amountComparison != 0) {
                        return amountComparison;
                    }
                    // 如果金额相同，按原始顺序排序（比较索引）
                    return Integer.compare(s.indexOf(entry1.getKey()), s.indexOf(entry2.getKey()));
                })
                .map(Map.Entry::getKey) // 提取排序后的姓名
                .collect(Collectors.toList()); // 收集成结果列表
    }

    public static void main(String[] args) {
        // 测试样例1
        System.out.println(solution(4, Arrays.asList("a", "b", "c", "d"), Arrays.asList(1, 2, 2, 1))); // ['b', 'c', 'a', 'd']

        // 测试样例2
        System.out.println(solution(3, Arrays.asList("x", "y", "z"), Arrays.asList(100, 200, 200))); // ['y', 'z', 'x']

        // 测试样例3
        System.out.println(solution(5, Arrays.asList("m", "n", "o", "p", "q"), Arrays.asList(50, 50, 30, 30, 20))); // ['m', 'n', 'o', 'p', 'q']
    }
}
