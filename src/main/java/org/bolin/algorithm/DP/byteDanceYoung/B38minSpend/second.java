package org.bolin.algorithm.DP.byteDanceYoung.B38minSpend;

import java.util.Arrays;

public class second {

    public static int solution(int m, int n, int[][] p) {
        int[] dpOld=new int[m];
        int[] dpNew=new int[m];
        Arrays.fill(dpOld,Integer.MAX_VALUE-1000);
        Arrays.fill(dpNew,Integer.MAX_VALUE-1000);
        dpOld[0]=p[0][1];
        for(int i=0;i<n;i++){
            int tmpDay=p[i][0];
            if(tmpDay==m){
                continue;
            }
            if(i==n-1){
                int h=1;
            }
//            m  : 天数   n: 补给站个数
            for(int j=tmpDay;j<m;j++){

                int value1=Integer.MAX_VALUE;
                int value2=Integer.MAX_VALUE;
                int value3=Integer.MAX_VALUE;
                if(j-1>=0){
                    value1=dpNew[j-1]+p[i][1];
                    value2=dpOld[j-1]+p[i][1];
                }

                if(j>=0){
                    value3=dpOld[j];
                }
//                注意这句不能漏掉了啊 ,注意是min啊
                dpNew[j]=Math.min(Math.min(value1,value2),value3);

            }
//
            int [] tmp=dpOld;
            dpOld=dpNew;
            dpNew=tmp;
            Arrays.fill(dpNew,Integer.MAX_VALUE-1000);
        }
        System.out.println(dpOld[m-1]);
        return dpOld[m-1];
    }
    public static int[][]  stringToArray(String str2){
        String str;
        // 给定字符串
        str=str2;

        // 1. 去掉外层方括号
        str = str.substring(1, str.length() - 1);

        // 2. 按 "]," 分割
        String[] pairs = str.split("],");

        // 3. 创建二维数组
        int[][] array = new int[pairs.length][2];

        for (int i = 0; i < pairs.length; i++) {
            // 去掉每个 pair 的方括号
            String pair = pairs[i].replace("[", "").replace("]", "");
            String[] nums = pair.split(",");

            // 转换为整数并赋值
            array[i][0] = Integer.parseInt(nums[0]);
            array[i][1] = Integer.parseInt(nums[1]);
        }

        // 输出验证结果
        System.out.println("二维数组内容：");
        for (int[] pair : array) {
            System.out.println(Arrays.toString(pair));
        }
        return array;
    }
    public static void main(String[] args) {
        // Add your test cases here
        String str="[[0,1],[1,18],[2,6],[3,2],[4,7],[5,13],[6,1],[7,21],[8,25],[9,25],[10,10],[11,19],[12,11],[13,17],[14,21],[15,23],[16,7],[17,13],[18,25],[19,22],[20,7],[21,22],[22,17],[23,11],[24,6]]";
        String str2="[[0,2],[1,3],[2,1],[3,2]]";
        int[][] ints = stringToArray(str);
        System.out.println(solution(5, 4, ints) == 7);
    }

}
