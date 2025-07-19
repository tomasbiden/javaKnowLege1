package org.bolin.algorithm.backtracking.suiXiangLu.L39combinationSum;


import java.util.ArrayList;
import java.util.List;

class L39combinationSum_250719_1{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result=new ArrayList<>();
            dfs(candidates,target,0,new ArrayList<>(),result,0);
            return result;
    }

    private void dfs(int[] candidates,int startIndex,int target,List<Integer> path,List<List<Integer>> result,int tmpSumValue){
        if(tmpSumValue>target){
            return;
        }
        if(tmpSumValue==target){
            result.add(new ArrayList<>(path));
        }
//       注意过滤问题啊
        for(int i=startIndex;i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(candidates,target,i,path,result,tmpSumValue+candidates[i]);
            path.remove(path.size()-1);
        }

    }
}
public class L39combinationSum {
}
