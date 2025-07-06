package org.bolin.algorithm.Array.Leecode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<int[]> result=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int resultSize=result.size();
//           注意是大于等于
            if(i>0&&result.get(resultSize-1)[1]>=intervals[i][0]){
                result.get(resultSize-1)[1]=Math.max(result.get(resultSize-1)[1],intervals[i][1]);
            }else{
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
