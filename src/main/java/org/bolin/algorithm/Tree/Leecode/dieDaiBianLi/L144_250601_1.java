package org.bolin.algorithm.Tree.Leecode.dieDaiBianLi;



import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L144_250601_1 {
    LinkedList<Pair<TreeNode,Boolean>> linkedList=new LinkedList<Pair<TreeNode,Boolean>>();
    List<Integer> result=new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        linkedList.addLast(new Pair<>(root,false));
        while (!linkedList.isEmpty()){
            Pair<TreeNode, Boolean> last = linkedList.removeLast();
            if(last.value){
                result.add(last.key.val);
            }else{
                if(last.key.right!=null){
                    linkedList.addLast(new Pair<>(last.key.right,false));
                }

                if(last.key.left!=null){
                    linkedList.addLast(new Pair<>(last.key.left,false));
                }
                last.value=true;
                linkedList.addLast(last);
            }

        }
        return result;

    }

    public static void main(String[] args){
        // 构建对称树
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        L144_250601_1 l1442506011 = new L144_250601_1();
        for (Integer i : l1442506011.preorderTraversal(root)) {
            System.out.println(i);
        }


    }

}
class Pair<K,V>{
    public K key;
    public V value;
    public Pair(K k,V v){
        this.key=k;
        this.value=v;
    }
}
