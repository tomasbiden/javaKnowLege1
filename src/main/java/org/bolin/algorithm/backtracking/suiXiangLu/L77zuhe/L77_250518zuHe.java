package org.bolin.algorithm.backtracking.suiXiangLu.L77zuhe;

import java.util.ArrayList;
import java.util.List;

public class L77_250518zuHe {
    List<List<Integer>> result;
//  注意要定义一个path啊
//    注意下初始化啊
    List<Integer> path=new ArrayList<>();
    public void backTracking(int startIndex,int[] arr ,int k){
        if(path.size()==k){
//            注意要复制啊
            result.add(new ArrayList<>(path));
//            谁跟你说是清空，是移除最后一个元素啊
//            path.clear();

//            注意return 啊
             return;
        }
//        注意这个长度，能够增加的最大长度和当前已有的长度
        for(int i=startIndex;arr.length-i+path.size()>=k;i++){
            path.add(arr[i]);
            backTracking(i+1,arr,k);
            path.remove(path.size()-1);
        }

    }

    public List<List<Integer>> combine(int n, int k) {
//       从第几个索引开始选择 ,从数组中选择数字，一共需要选择k个树
        result=new ArrayList<>();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
//       你的调用呢,索引记得是从0开始的啊
        backTracking(0,arr,k);
        return  result;
//        1: for 在backTracking 哪里本身就有了啊，你自己在父目录不用写啊
//        for(int i=0;i<n;i++){
//            backTracking(i,arr,k);
//        }


    }
    public static void main(String[] args){
        L77_250518zuHe l77zuHe = new L77_250518zuHe();
        l77zuHe.combine(5,3);

    }
}
