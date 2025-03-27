package org.bolin.algorithm.hashTable.Leecode;

import jodd.util.CollectionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L15threeSum {

    public List<List<Integer>> threeSum_250326(int[] nums) {
        if(nums.length<3){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        List<List<Integer>> resultList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(i>0&&list.get(i)==list.get(i-1)){
                continue;
            }
            int j=i+1;
            int k=list.size()-1;
            while (j<k){
                int sum=list.get(i)+list.get(j)+list.get(k);
                if(sum>0){
                    k--;
                    continue;
                }
                if(sum<0){
                    j++;
                    continue;
                }
                ArrayList<Integer> itemList = new ArrayList<>();
                itemList.add(list.get(i));
                itemList.add(list.get(j));
//                itemList.add(nums[k]);   注意是list.get 而不是nums啊
                itemList.add(list.get(k));
                resultList.add(itemList);

                while (j<k&&list.get(j)==list.get(j+1)){
                    j++;
                }
                while (j<k&&list.get(k)==list.get(k-1)){
                    k--;
                }
                j++;k--;

            }
        }
        return  resultList;


    }

    public List<List<Integer>> threeSum_modify(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[j], c = nums[k]
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && list.get(i)==list.get(i-1)) {  // 去重a
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                    continue;
                }
                if (sum < 0) {
                    j++;
                    continue;
                }

                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (k > j && list.get(k) == list.get(k-1)) k--;
                    while (k > j && list.get(j) == list.get(j+1)) j++;

                    k--;
                    j++;

            }
        }
        return result;
    }



    public List<List<Integer>> threeSum_correct1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                    continue;
                }
                if (sum < 0) {
                    left++;
                    continue;
                }

                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                while (right > left && nums[right] == nums[right - 1]) {
                    right--;
                }
                while (right > left && nums[left] == nums[left + 1]){
                    left++;
                }

                right--;
                left++;

            }
        }
        return result;
    }

//    list.get(j) == list.get(j+1) 这里是问题代码，设计了 基本数据类型与包装数据类型的等值比较问题

    public List<List<Integer>> threeSum_error(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[j], c = nums[k]
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && list.get(i)==list.get(i-1)) {  // 去重a
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                    continue;
                }
                if (sum < 0) {
                    j++;
                    continue;
                }
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                while (k > j && nums[k] == nums[k-1]) k--;
                while (k > j && nums[j] == nums[j+1]) j++;

                k--;
                j++;

            }
        }
        return result;
    }

    public List<List<Integer>> threeSum_correct1_modify1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                    continue;
                }
                if (sum < 0) {
                    j++;
                    continue;
                }

                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                while (k> j && nums[k] == nums[k - 1]) {
                    k--;
                }
                while (k > j && nums[j] == nums[j + 1]){
                    j++;
                }

                k--;
                j++;

            }
        }
        return result;
    }

    public List<List<Integer>> threeSum_correct1_modify3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                    continue;
                }
                if (sum < 0) {
                    j++;
                    continue;
                }

                ArrayList<Integer> itemList = new ArrayList<>();
                itemList.add(list.get(i));
                itemList.add(list.get(j));
//                itemList.add(nums[k]);   注意是list.get 而不是nums啊
                itemList.add(list.get(k));
                result.add(itemList);

                // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                while (k> j && nums[k] == nums[k - 1]) {
                    k--;
                }
                while (k > j && nums[j] == nums[j + 1]){
                    j++;
                }

                k--;
                j++;

            }
        }
        return result;
    }

    public List<List<Integer>> threeSum_correct1_modify4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                int sum = list.get(i) +list.get(j) + list.get(k);
                if (sum > 0) {
                    k--;
                    continue;
                }
                if (sum < 0) {
                    j++;
                    continue;
                }

                ArrayList<Integer> itemList = new ArrayList<>();
                itemList.add(list.get(i));
                itemList.add(list.get(j));
//                itemList.add(nums[k]);   注意是list.get 而不是nums啊
                itemList.add(list.get(k));
                result.add(itemList);

                // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                while (k> j && nums[k] == nums[k - 1]) {
                    k--;
                }
                while (k > j && nums[j] == nums[j + 1]){
                    j++;
                }

                k--;
                j++;

            }
        }
        return result;
    }
}
