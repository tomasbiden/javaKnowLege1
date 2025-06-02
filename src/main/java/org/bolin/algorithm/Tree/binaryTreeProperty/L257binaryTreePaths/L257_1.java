package org.bolin.algorithm.Tree.binaryTreeProperty.L257binaryTreePaths;

import org.bolin.algorithm.Tree.Leecode.dieDaiBianLi.L144_250601_1;
import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class L257_1 {
    List<String> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public void traversal(TreeNode root){
        if(root.left!=null){
            path.add(root.val);
            traversal(root.left);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            path.add(root.val);
            traversal(root.right);
            path.remove(path.size()-1);
        }
//        叶子节点注意也需要加入到结果中啊
        if(root.left==null&&root.right==null){
            path.add(root.val);
            String stringPaht = path.stream().map(String::valueOf).collect(Collectors.joining("->"));
            result.add(stringPaht);
            path.remove(path.size()-1);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
            traversal(root);
            return  result;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        L257_1 l2571 = new L257_1();
        for (String binaryTreePath : l2571.binaryTreePaths(root)) {
            System.out.println(binaryTreePath);
        }


    }
}
