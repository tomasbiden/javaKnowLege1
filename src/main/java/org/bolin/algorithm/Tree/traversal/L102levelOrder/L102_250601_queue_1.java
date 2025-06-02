package org.bolin.algorithm.Tree.traversal.L102levelOrder;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.*;

public class L102_250601_queue_1 {
    List<List<Integer>> result=new ArrayList<>();

    Queue<TreeNode> queue=new LinkedList<TreeNode>();

    public List<List<Integer>> levelOrder_bfs_queue(TreeNode root) {

        if(root==null){
            return  result;
        }
        queue.offer(root);
        while (queue.size()>0){
            int len=queue.size();
            List<Integer> tmpLevelList=new ArrayList<>();
            while (len>0){
                TreeNode tmpNode = queue.poll();
                tmpLevelList.add(tmpNode.val);
                if(tmpNode.left!=null){
                    queue.offer(tmpNode.left);
                }
                if(tmpNode.right!=null){
                    queue.offer(tmpNode.right);
                }
                len--;


            }
            result.add(tmpLevelList);
        }
        return result;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        traversal_front(root,0);
        return result;
    }

    public void traversal_front(TreeNode root, int deep){
        deep++;
        List<Integer> deepList;
        if(result.size()<deep){
            deepList=new ArrayList<>();
            result.add(deepList);
        }else{
            deepList=result.get(deep-1);
        }
        deepList.add(root.val);
        if(root.left!=null){
            traversal_front(root.left,deep);
        }
        if(root.right!=null){
            traversal_front(root.right,deep);
        }


    }


}
