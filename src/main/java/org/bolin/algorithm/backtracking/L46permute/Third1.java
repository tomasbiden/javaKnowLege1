package org.bolin.algorithm.backtracking.L46permute;

import java.util.ArrayList;
import java.util.List;

public class Third1 {
    List<List<Character>> res = new ArrayList<>();
    ArrayList<Character> path = new ArrayList<>();


    boolean[] booleans;

    public List<List<Character>> permute(char[] nums) {

        booleans = new boolean[nums.length];


        permuteHelper(nums);

        return res;
    }

    public void permuteHelper(char[] chars) {



            ArrayList<Character> pathSave = new ArrayList<>(path);
            res.add(pathSave);



        // 遍历所有字符，进行选择
        for (int i = 0; i < chars.length; i++) {

            if (booleans[i]) {
                continue;
            }


            booleans[i] = true;
            path.add(chars[i]);


            permuteHelper(chars);


            booleans[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Third1 my1241023 = new Third1();
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e'};
        List<List<Character>> permutations = my1241023.permute(chars);

        // 输出所有排列
        System.out.println(permutations);
    }
}
