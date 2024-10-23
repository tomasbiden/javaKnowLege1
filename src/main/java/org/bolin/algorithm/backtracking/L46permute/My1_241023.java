package org.bolin.algorithm.backtracking.L46permute;

import java.util.ArrayList;
import java.util.List;

public class My1_241023 {
    List<List<Integer>> res=new ArrayList<>();

    ArrayList<Integer>path= new ArrayList<>();


//    数组作为成员变量必须赋大小
    boolean[] used2=new boolean[1];

//    这样子就可以了
    boolean[] used;

    boolean[] booleans;


    public List<List<Integer>> permute(int[] nums) {
        int len=nums.length;
        booleans= new boolean[nums.length];
        boolean x=booleans[0];

        boolean[] bl=new boolean[2];
        boolean[]  b2={true,true,true};
        boolean[]  b3;
//        b3=new boolean[2];  正确
//        b3={true,true,false};   错误
//        b3= new boolean[]{true,true,true}; 正确
        boolean[] b4=new boolean[]{true,true,true};
//        boolean[] b4= new boolean[2]{true,true}; 错误的方式


        System.out.println(x);
        permuteHelper(nums,booleans);


        return  res;

    }
    public  void permuteHelper(int[] nums,boolean[] booleans){
        if(path.size()==nums.length){

//
            ArrayList<Integer> pathSave = new ArrayList<Integer>(path);
//         res.add(path) 是错误的，因为 实际上保存的是path的引用，  而path 最终是会置为空的啊
            res.add(pathSave);
            System.out.println(pathSave+ " "+ res);
        }
        for(int i=0;i<nums.length;i++){
            if(!booleans[i]){
                booleans[i]=true;
                path.add(nums[i]);


                permuteHelper(nums,booleans);
//
                booleans[i]=false;
                path.remove(path.size()-1);
            }
        }

    }
    public static void main(String [] args){
        My1_241023 my1241023 = new My1_241023();
        int[] nums=new int[]{1,2,3};
        my1241023.permute(nums);
//        System.out.println(my1241023.res);




    }
}
