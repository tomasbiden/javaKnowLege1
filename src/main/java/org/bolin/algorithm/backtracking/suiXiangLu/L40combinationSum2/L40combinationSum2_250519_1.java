package org.bolin.algorithm.backtracking.suiXiangLu.L40combinationSum2;

import java.util.ArrayList;
import java.util.List;

public class L40combinationSum2_250519_1 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
           backTracking(0,candidates,target);

           return result;
    }

    List<List<Integer>> result=new ArrayList<>();
    //  注意要定义一个path啊
//    注意下初始化啊
    List<Integer> path=new ArrayList<>();

    int sum=0;

    //    4:定义回溯函数
//            4.1 参数配置：
//                    4.1.1 数组开始索引位置   4.1.2 从那个数组开始选择  4.1.3 一共要选择k个数
    public void backTracking(int startIndex,int[] arr ,int target){
//      5：如果path大小等于k,则将基于path构造一共新list加入到result中
        if(sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
//      6 for循环
//      6.1 起点为startIndex, 迭代为i++，条件[剪枝为数组可供选择的个数(arr.length-i)加上当前已有路径的个数>=k
//      6.2 向路径中加入数字
//      6.3 i+1进行回溯
//      6.4 从路径中删除path最后一位数字
        for(int i=startIndex;i<arr.length&&sum<target;i++){
            path.add(arr[i]);
            sum+=arr[i];
            backTracking(0,arr,target);
            path.remove(path.size()-1);
            sum-=arr[i];
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
        L40combinationSum2_250519_1 l40combinationSum22505191 = new L40combinationSum2_250519_1();
        int[] arr={10,1,2,7,6,1,5};
        List<List<Integer>> lists = l40combinationSum22505191.combinationSum2(arr, 8);
        int h=1;



    }
}
