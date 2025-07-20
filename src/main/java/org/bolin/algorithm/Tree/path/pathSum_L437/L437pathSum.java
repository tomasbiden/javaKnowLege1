package org.bolin.algorithm.Tree.path.pathSum_L437;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

class L437pathSum_250720_1{
    int result=0;
    public int pathSum(TreeNode root, int targetSum) {
//       1：注意sum用Long
        Map<Long,Integer> from0SumCntMap=new HashMap<>();
        from0SumCntMap.put(0L,1);
        traversal(root,targetSum,0L,from0SumCntMap);

        return result;

    }

    private void traversal(TreeNode root,int targetNum,long sum,Map<Long,Integer> from0SumCntMap){
        if(root==null){
            return;
        }
//       2:先统计后处理Map
        result+=from0SumCntMap.getOrDefault(sum+root.val-targetNum,0);
        from0SumCntMap.merge(sum+root.val,1,Integer::sum);

        traversal(root.left,targetNum,sum+root.val,from0SumCntMap);


        traversal(root.right,targetNum,sum+root.val,from0SumCntMap);
        from0SumCntMap.merge(sum+root.val,-1,Integer::sum);

    }
}
public class L437pathSum {
}
