package org.bolin.algorithm.Tree.build.buildLinkedList;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

 class  Flatten_250720_1{
    public void flatten(TreeNode root) {
        traversal(root);
    }

    private TreeNode traversal(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode leftTail = traversal(root.left);
        if(leftTail!=null){
            leftTail.right=root.right;
            root.right=root.left;
            root.left=null;
        }

        TreeNode rightTail = traversal(root.right);



        if(leftTail==null&&rightTail==null ){
            return root;
        }
        return rightTail==null?leftTail:rightTail;


    }

    // 构造树：基于层序遍历数组构造二叉树
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
     public static void main(String[] args) {
         Integer[] arr = {1, 2, 5, 3, 4, null, 6};
         TreeNode root = buildTree(arr);
         Flatten_250720_1 flatten2507201 = new Flatten_250720_1();
         flatten2507201.traversal(root);



         // 打印前序遍历结果验证

     }


}
class  Flatten_250629_1{

    TreeNode head=null;
    public void flatten(TreeNode root) {
        if(root==null){
         return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left=null;
        root.right=head;
        head=root;
    }

}
public class L114Flatten {
}
