package org.bolin.algorithm.Tree.build.buildTreeFromPreAndInOrder;


import org.bolin.algorithm.Tree.model.TreeNode;
import org.graalvm.nativebridge.In;

import java.util.HashMap;
import java.util.Map;

class L105buildTree_250720_1{
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inorderValueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
        inorderValueIndexMap.put(inorder[i],i);

        }
        return buildTreeWithIndex(preorder,0,preorder.length,inorder,0,inorder.length,inorderValueIndexMap);
    }

    public TreeNode buildTreeWithIndex(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer,Integer> valueInOrderIndexMap) {
        if(pStart>=pEnd||iStart>=iEnd){
            return null;
        }
        int rootValue=preorder[pStart];
        int inorderIndex=valueInOrderIndexMap.get(rootValue);
        TreeNode root=new TreeNode(preorder[pStart]);
        int leftLen=inorderIndex-iStart;

        root.left=buildTreeWithIndex(preorder,pStart+1,pStart+1+leftLen,inorder,iStart,inorderIndex,valueInOrderIndexMap);
        root.right=buildTreeWithIndex(preorder,pStart+1+leftLen,pEnd,inorder,inorderIndex+1,iEnd,valueInOrderIndexMap);
        return root;
    }


}
public class L105buildTree {
}
