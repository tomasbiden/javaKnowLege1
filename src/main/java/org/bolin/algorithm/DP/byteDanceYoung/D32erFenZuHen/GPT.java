package org.bolin.algorithm.DP.byteDanceYoung.D32erFenZuHen;

public class GPT {
    public static int solution(int n, int A, int B, int[] array) {
        // 初始化 DP 数组
        boolean[][] dp = new boolean[10][10];
        dp[0][0] = true; // 初始状态：没有任何数字时，两组和为 0 可行

        // 遍历数组中的每个数字
        for (int num : array) {
            // 使用临时数组保存当前状态的更新
            boolean[][] newDp = new boolean[10][10];
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    if (dp[x][y]) { // 如果当前状态可达
                        newDp[x][y] = true; // 保持原状态
                        newDp[(x + num) % 10][y] = true; // 放入第一组
                        newDp[x][(y + num) % 10] = true; // 放入第二组
                    }
                }
            }
            dp = newDp; // 更新 DP 表
        }

        // 统计符合条件的划分方式
        int result = 0;
        // 情况 1：两组均非空，分别满足 A 和 B
        if (dp[A][B]) result++;
        // 情况 2：第一组为空，第二组和的个位数为 B
        for (int x = 0; x < 10; x++) {
            if (dp[x][B]) {
                result++;
                break; // 避免重复计数
            }
        }
        // 情况 3：第二组为空，第一组和的个位数为 A
        for (int y = 0; y < 10; y++) {
            if (dp[A][y]) {
                result++;
                break; // 避免重复计数
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 测试样例 1
        System.out.println(solution(3, 1, 2, new int[]{1, 1, 1})); // 输出：3
        // 测试样例 2
        System.out.println(solution(3, 3, 5, new int[]{1, 1, 1})); // 输出：1
        // 测试样例 3
        System.out.println(solution(2, 1, 1, new int[]{1, 1})); // 输出：2
        // 测试样例 4
        System.out.println(solution(5, 3, 7, new int[]{2, 3, 5, 7, 9})); // 输出：0
    }
}
