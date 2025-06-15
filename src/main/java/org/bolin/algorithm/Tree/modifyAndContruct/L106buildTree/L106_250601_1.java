package org.bolin.algorithm.Tree.modifyAndContruct.L106buildTree;

import org.bolin.algorithm.Tree.model.TreeNode;


import java.util.HashMap;
import java.util.Map;

public class L106_250601_1 {
    Map<Integer,Integer> inValueIndexMap=new HashMap<>();
    public TreeNode buildFromInAndPostArray(int inBegin,int inEnd,int postBegin,int postEnd,int[] inorder,int[] postorder){
        if(inBegin>=inEnd||postBegin>=postEnd){
            return  null;
        }
        int rootValue=postorder[postEnd-1];
         int inRootIndex = inValueIndexMap.get(rootValue);
        int inLeftLen=inRootIndex-inBegin;
        TreeNode treeNode = new TreeNode(rootValue);
        treeNode.left=buildFromInAndPostArray(inBegin,inRootIndex,postBegin,postBegin+inLeftLen,inorder,postorder);
//        注意这个 -1 舍弃掉最后一个值啊
        treeNode.right=buildFromInAndPostArray(inRootIndex+1,inEnd,postBegin+inLeftLen,postEnd-1,inorder,postorder);
        return treeNode;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        注意从0开始的啊
        for(int i=0;i<inorder.length;i++){
            inValueIndexMap.put(inorder[i],i);
        }
       return buildFromInAndPostArray(0,inorder.length,0,postorder.length,inorder,postorder);


    }
    public static void main(String[] args){

    }
}
