package org.bolin.byteDance;

import java.util.ArrayList;

public class P118 {

    public static int solution(String version1, String version2) {
        // Edit your code here



        String[] parts1 = version1.split("\\.");
        ArrayList<Integer> list1 = new ArrayList<>();

        for (String part : parts1) {
                Integer value = Integer.parseInt(part);

                list1.add(value);
        }

        String[] parts2 = version2.split("\\.");
        ArrayList<Integer> list2 = new ArrayList<>();

        for (String part : parts2) {
            Integer value = Integer.parseInt(part);

            list2.add(value);
        }
        int maxIndex=Math.max(list1.size(),list2.size());
        for(int i=0;i<maxIndex;i++){
            int num1=((i+1)>list1.size()?0:list1.get(i));
            int num2=((i+1)>list2.size()?0:list2.get(i));
            if(num1>num2){
                return 1;
            }
            if(num1<num2){
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("0.1", "1.1") == -1);
        System.out.println(solution("1.0.1", "1") == 1);
        System.out.println(solution("7.5.2.4", "7.5.3") == -1);
        System.out.println(solution("1.0", "1.0.0") == 0);
    }


}
