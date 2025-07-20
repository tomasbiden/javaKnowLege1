package org.bolin.algorithm.Tree.Leecode.L102levelOrder;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class L102levelOrder_250720_1{
    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> result=new ArrayList<>();
//       注意空处理
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (queue.size()>0){
            int len=queue.size();
            List<Integer> levelList=new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode poll = queue.poll();
                levelList.add(poll.val);
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }

}public class L102levelOrder {
}
