package org.save1.Tree.niukehot100.BM23qianXuBianLi;


import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BM23qianXuBianLi {
    public static void inorder(List list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list,root.right);

    }

    public static int[] inorderTraversal(TreeNode root) {
        // write code here


        if (root == null) {

            int [] arr=new int[0] ;
            return  arr;

        }
        ArrayList<Integer> array = new ArrayList<>();
        inorder(array,root);
        int[] array1 = array.stream().mapToInt(Integer::intValue).toArray();

        if(array1.length==0){
            System.out.println("sdfsdf");
        }
        return array1;


    }

    public static void main(String[] args) {
        System.out.println("sdfs");
    }
}
