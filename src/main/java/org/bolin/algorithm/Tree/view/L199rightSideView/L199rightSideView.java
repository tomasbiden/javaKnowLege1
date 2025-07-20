package org.bolin.algorithm.Tree.view.L199rightSideView;


import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class L199rightSideView_250720_1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);

        while (queue.size() > 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }

                if (i == len - 1) {
                    result.add(poll.val);
                }
            }


        }

        return result;
    }

}

public class L199rightSideView {
}
