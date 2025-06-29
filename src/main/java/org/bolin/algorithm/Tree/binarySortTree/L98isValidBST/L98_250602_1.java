package org.bolin.algorithm.Tree.binarySortTree.L98isValidBST;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// [5,4,6,null,null,3,7]
// 3小于5,因此不能是搜索树
class T_error_20250628_1 {


    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);

        int leftValue=root.left==null?Integer.MIN_VALUE:root.left.val;
        int rightValue=root.right==null?Integer.MAX_VALUE:root.right.val;
        if (left && right) {
            return  root.val>leftValue&&root.val <rightValue;
        }else{
            return  false;
        }
    }

}

class T__20250628_2 {

    List<Integer> result=new ArrayList<>();
    public void  traversal(TreeNode root ){

       if(root==null){
           return;
       }
       traversal(root.left);
       result.add(root.val);
       traversal(root.right);

    }
    public boolean isValidBST(TreeNode root) {
      traversal(root);
      for(int i=0;i<result.size();i++){
          if(i==0){
              continue;
          }
//         注意是小于等于啊
          if(result.get(i)<=result.get(i-1)){
              return  false;
          }
      }
      return true;
    }

}

public class L98_250602_1 {
    TreeNode tmpMaxNode;

    public boolean isValidBST(TreeNode root) {


        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) return false;
//        这里会导致一直 return false
        /*
        if(tmpMaxNode!=null&&root.val>tmpMaxNode.val){
            tmpMaxNode=root;
            return isValidBST(root.right);
        }else{
            return  false;
        }

         */

        if (tmpMaxNode != null && tmpMaxNode.val >= root.val) {
            return false;
        }
        tmpMaxNode = root;
        return isValidBST(root.right);
    }
}
