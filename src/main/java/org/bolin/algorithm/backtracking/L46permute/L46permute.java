package org.bolin.algorithm.backtracking.L46permute;

import java.util.ArrayList;
import java.util.List;

class L46permute_250719_1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums,new boolean[nums.length],result,path);
        return result;
    }

    public void dfs(int[] nums, boolean visited[], List<List<Integer>> result, List<Integer> tmpPath) {
        if (tmpPath.size() == nums.length) {
//           注意对象需要初始化一下啊
            result.add(new ArrayList<>(tmpPath));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmpPath.add(nums[i]);
                dfs(nums, visited, result, tmpPath);
                visited[i] = false;
                tmpPath.remove(tmpPath.size() - 1);
            }
        }

    }
}

public class L46permute {
}
