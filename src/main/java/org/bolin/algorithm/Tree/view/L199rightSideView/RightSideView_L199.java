package org.bolin.algorithm.Tree.view.L199rightSideView;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RightSideView_L199_250629_1{

    Queue<TreeNode> queue=new LinkedList<>();

    List<Integer> result=new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
                if(i==len-1){
                    result.add(poll.val);
                }

            }
        }

        return  result;
    }

}
public class RightSideView_L199 {
}
