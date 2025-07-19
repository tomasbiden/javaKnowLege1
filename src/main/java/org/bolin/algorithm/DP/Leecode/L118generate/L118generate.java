package org.bolin.algorithm.DP.Leecode.L118generate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class  L118generate_250707_1{
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        result.add(Arrays.asList(1));
        for(int i=1;i<numRows;i++){
           List<Integer> rowList= new ArrayList<>();
           rowList.add(1);
           for(int j=1;j<i;j++){
               int value=result.get(i-1).get(j-1)+result.get(i-1).get(j);
               rowList.add(value);
           }
           rowList.add(1);
           result.add(rowList);
        }
        return result;
    }
}
public class L118generate {
}
