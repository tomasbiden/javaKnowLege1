package org.bolin.algorithm.Tree.binarySortTree.KthSmallest_L230;

import org.bolin.algorithm.Tree.model.TreeNode;

class T20250628_1{
    class Result{
        boolean find;
        int value;
        int cnt=0;
    }



    public void traversal(TreeNode root ,int k,Result result ){
        if(root==null){
            return;
        }

        traversal(root.left,k,result);
        if(result.find){
            return ;
        }
        result.cnt=result.cnt+1;
        if(result.cnt==k){
            result.value=root.val;
            return;
        }
        traversal(root.right,k,result);
    }






    class TraversalResult{
        int order;
        int result;
        public TraversalResult(int order,int result){
            this.order=order;
            this.result=result;
        }
    }

    public static int testAdd(int x){
        x++;
        return x;

    }

    public static void main(String[] args){
        int[] ints = {1,-1,2};

//        TreeNode treeNode = BuildTree.buildBinaryTreeFromArray(0, ints);
//        T20250628_1 t202506281 = new T20250628_1();
//        int i = t202506281.kthSmallest(treeNode, 2);
        int x=2;
        testAdd(x);
        int h=1;

    }

}

class T20250628_2{

    static class ObjClass{
        int x;
        public ObjClass(int x){
            this.x=x;
        }
    }
    public static void modifyX(ObjClass objClass){
        objClass.x= 8;
    }

    public static void main(String [] args){
        ObjClass objClass = new ObjClass(6);
        modifyX(objClass);
        System.out.println(objClass.x);


    }
}
// 最终的模板方法
class T20250628_3{

    class Result{
        boolean find;
        int value;
        int cnt=0;
    }

    public void traversal(TreeNode root ,int k,Result result ){
        if(root==null){
            return;
        }

        traversal(root.left,k,result);
        if(result.find){
            return ;
        }
        result.cnt=result.cnt+1;
        if(result.cnt==k){
            result.value=root.val;
            return;
        }
        traversal(root.right,k,result);
    }
    public int kthSmallest(TreeNode root, int k) {
        Result result=new Result();
        traversal(root,k,result);
        return result.value;
    }
}
public class KthSmallest {


}
