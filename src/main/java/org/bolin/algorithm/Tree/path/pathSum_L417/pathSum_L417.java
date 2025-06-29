package org.bolin.algorithm.Tree.path.pathSum_L417;


import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

class  pathSum_L417_250629_1{
//   注意用Long, 有数组越界问题

    int ans=0;

    public void traversal(TreeNode root, int targetSum,Long sum, Map<Long,Integer> cnt){
        if(root==null){
            return;
        }
        sum+=root.val;
        ans+=cnt.getOrDefault(sum-targetSum,0);
        cnt.merge(sum,1,Integer::sum);
        traversal(root.left,targetSum,sum,cnt);
        traversal(root.right,targetSum,sum,cnt);
        cnt.merge(sum,-1,Integer::sum);

    }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> map=new HashMap<>();
        map.put(0L,1);
        traversal(root,targetSum,0L,map);
        return ans;
    }
}
public class pathSum_L417 {
}
