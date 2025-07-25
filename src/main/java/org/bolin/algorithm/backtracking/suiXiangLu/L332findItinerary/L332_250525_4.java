package org.bolin.algorithm.backtracking.suiXiangLu.L332findItinerary;

import java.util.*;

class L332_250525_4 {
       Map<String, Map<String,Integer>>  map=new HashMap<>();
    LinkedList<String> res=new LinkedList<>();

    public boolean backTracking(int siteSize){
        if(res.size() == siteSize + 1){
            return true;
        }
        String last = res.getLast();
        if(map.containsKey(last)){//防止出现null
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if(backTracking(siteSize)) return true;
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;

    }
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(map.containsKey(t.get(0))){
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                temp = new TreeMap<>();//升序Map
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);

        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }
}