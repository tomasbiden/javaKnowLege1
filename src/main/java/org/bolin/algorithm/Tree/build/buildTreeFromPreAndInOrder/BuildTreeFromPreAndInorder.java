package org.bolin.algorithm.Tree.build.buildTreeFromPreAndInOrder;


import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

class T20250629_1{

    Map<Integer,Integer> inOrderValueIndexMap=new HashMap<>();

    public TreeNode buildTreeFromIndex(int preStart,int preEnd,int inStart ,int inEnd,int[] preorder, int[] inorder) {
        if(preStart>=preEnd){
            return null;
        }
        TreeNode root =new TreeNode(preorder[preStart]);
        int rootIndex=inOrderValueIndexMap.get(preorder[preStart]);
        int leftLen=rootIndex-inStart;
        root.left=buildTreeFromIndex(preStart+1,preStart+1+leftLen,inStart,rootIndex,preorder,inorder);
        root.right=buildTreeFromIndex(preStart+1+leftLen,preEnd,rootIndex+1,inEnd,preorder,inorder);
        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
            for(int i=0;i<inorder.length;i++){
                inOrderValueIndexMap.put(inorder[i],i);
            }
            return buildTreeFromIndex(0,preorder.length,0,inorder.length,preorder,inorder);

    }

}
public class BuildTreeFromPreAndInorder {
}
