package org.bolin.algorithm.Tree.binaryTreeAncestor.L236lowestCommonAncestor;


import org.bolin.algorithm.Tree.model.TreeNode;

class L236lowestCommonAncestor_250720_1{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root,p,q);
    }
    private TreeNode traversal(TreeNode root,TreeNode p,TreeNode q){
//       注意空异常处理啊
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left = traversal(root.left, p, q);
        TreeNode right=traversal(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }else {
            return left==null?right:left;
        }

    }
}
public class L236lowestCommonAncestor {

}
