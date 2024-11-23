package org.bolin.algorithm.backtracking.L46permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class My1_241123_2 {
     int [] visited;
    List<List<Integer>> res=new ArrayList<>();

    List<Integer> tmpList=new ArrayList<>();
    public  void permuteHelper(int[] nums){
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(visited[i]==0){

                visited[i]=1;
                tmpList.add(nums[i]);

                if(tmpList.size()==nums.length){
                    ArrayList<Integer> saveList = new ArrayList<>(tmpList);
                    res.add(saveList);
                }

                permuteHelper(nums);
//              注意放的位置
                visited[i]=0;
                tmpList.remove(tmpList.size()-1);

            }

//            visited[i]=0;
//            tmpList.remove(tmpList.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {

            visited=new int[nums.length];
            Arrays.fill(visited,0);
            permuteHelper(nums);
            return  res;

    }
    public static void main(String[] args){
        int[] nums=new int[]{0,1,2};
        int[] nums2={1,2,3};
        int[] nums3=new int[4];

        My1_241123_2 my1241123 = new My1_241123_2();
        List<List<Integer>> permute = my1241123.permute(nums);

        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }
    }
}
