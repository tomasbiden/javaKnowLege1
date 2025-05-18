package org.bolin.algorithm.backtracking.suiXiangLu.L77zuhe;

import java.util.ArrayList;
import java.util.List;

public class L77_zuHe_temp {
//    1：结果与路径初始化
    List<List<Integer>> result=new ArrayList<>();
//  注意要定义一个path啊
//    注意下初始化啊
    List<Integer> path=new ArrayList<>();

//    4:定义回溯函数
//            4.1 参数配置：
//                    4.1.1 数组开始索引位置   4.1.2 从那个数组开始选择  4.1.3 一共要选择k个数
    public void backTracking(int startIndex,int[] arr ,int k){
//      5：如果path大小等于k,则将基于path构造一共新list加入到result中
        if(path.size()==k){
            result.add(new ArrayList<>(path));
             return;
        }
//      6 for循环
//      6.1 起点为startIndex, 迭代为i++，条件[剪枝为数组可供选择的个数(arr.length-i)加上当前已有路径的个数>=k
//      6.2 向路径中加入数字
//      6.3 i+1进行回溯
//      6.4 从路径中删除path最后一位数字
        for(int i=startIndex;arr.length-i+path.size()>=k;i++){
            path.add(arr[i]);
            backTracking(i+1,arr,k);
            path.remove(path.size()-1);
        }

    }

//    2：定义combine函数
    public List<List<Integer>> combine(int n, int k) {
//    3：数组初始化
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }

        backTracking(0,arr,k);
        return  result;


    }
    public static void main(String[] args){
        L77_zuHe_temp l77zuHe = new L77_zuHe_temp();
        l77zuHe.combine(5,3);

    }
}
