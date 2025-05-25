package org.bolin.algorithm.backtracking.suiXiangLu.L332findItinerary;

import java.util.*;

class L332_250525_3 {
    Map<String, Map<String,Integer>>  fromToCntMap=new HashMap<>();
    LinkedList<String> path=new LinkedList<>();

    public boolean backTracking(int siteSize){

        if(path.size()==siteSize){
            return true;
        }
        String siteName=path.getLast();
        if(fromToCntMap.containsKey(siteName)){
            Map<String, Integer> toCntMap = fromToCntMap.get(siteName);
            for (Map.Entry<String, Integer> stringIntegerEntry : toCntMap.entrySet()) {
                Integer cnt = stringIntegerEntry.getValue();
                if(cnt >0){
                    path.add(stringIntegerEntry.getKey());
//                   注意要设置次数防止死循环啊
                    stringIntegerEntry.setValue(cnt -1);
                    if( backTracking(siteSize)){
                        return true;
                    }
                    path.removeLast();
                    stringIntegerEntry.setValue(cnt );
                }
            }
        }
        return  false;



    }
    public List<String> findItinerary(List<List<String>> tickets) {
      for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(fromToCntMap.containsKey(t.get(0))){
                temp = fromToCntMap.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                temp = new TreeMap<>();//升序Map
                temp.put(t.get(1), 1);
            }
           fromToCntMap.put(t.get(0), temp);

        }
//        1：注意这两个的初始化啊
        path.add("JFK");
        backTracking(tickets.size()+1);
        return path;
    }
}