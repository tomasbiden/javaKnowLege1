package org.bolin.algorithm.backtracking.suiXiangLu.L216zuHeZongHe2;

import java.util.ArrayList;
import java.util.List;

public class L216_zuHeZonghe_temp {

    public List<List<Integer>> combinationSum3(int k, int n) {
        int newN=9;
        int sum=n;
        return combine(newN,k,sum);
    }

    List<List<Integer>> result=new ArrayList<>();
    //  注意要定义一个path啊
//    注意下初始化啊
    List<Integer> path=new ArrayList<>();

    //    4:定义回溯函数
//            4.1 参数配置：
//                    4.1.1 数组开始索引位置   4.1.2 从那个数组开始选择  4.1.3 一共要选择k个数
    public void backTracking(int startIndex,int[] arr,int k,int sum){
//      5：如果path大小等于k,则将基于path构造一共新list加入到result中
        if(path.size()==k&&path.stream().reduce(Integer::sum).orElse(0)==sum){
            result.add(new ArrayList<>(path));
            return;
        }
//      6 for循环
//      6.1 起点为startIndex, 迭代为i++，条件[剪枝为数组可供选择的个数(arr.length-i)加上当前已有路径的个数>=k
//      6.2 向路径中加入数字
//      6.3 i+1进行回溯
//      6.4 从路径中删除path最后一位数字
        for(int i=startIndex;arr.length-i+path.size()>=k&&i<arr.length;i++){
            path.add(arr[i]);
            backTracking(i+1,arr, k,sum);
            path.remove(path.size()-1);
        }

    }

    //    2：定义combine函数
    public List<List<Integer>> combine(int n, int k,int sum) {
//    3：数组初始化
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }

        backTracking(0,arr,k,sum);
        return  result;


    }
    public static void main(String[] args){


    }
}
