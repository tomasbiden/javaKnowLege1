package org.bolin.algorithm.backtracking.suiXiangLu.L332findItinerary;

import java.util.*;

public class L332_250525_1 {
    Map<String, Map<String,Integer>>  fromToCntMap=new HashMap<>();
    LinkedList<String> path=new LinkedList<>();

    public boolean backTracking(String siteName,int siteSize){
        if(path.size()==siteSize){
            return true;
        }
        if(fromToCntMap.containsKey(siteName)){
            Map<String, Integer> toCntMap = fromToCntMap.get(siteName);
            for (Map.Entry<String, Integer> stringIntegerEntry : toCntMap.entrySet()) {
                if(stringIntegerEntry.getValue()>0){
                    path.add(stringIntegerEntry.getKey());
//                   注意要设置次数防止死循环啊
                    stringIntegerEntry.setValue(stringIntegerEntry.getValue()-1);
                    if( backTracking(stringIntegerEntry.getKey(),siteSize)){
                        return true;
                    }
                    path.removeLast();
                    stringIntegerEntry.setValue(stringIntegerEntry.getValue()+1);
                }
            }
        }
        return  false;

    }
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            if(!fromToCntMap.containsKey(ticket.get(0))){
                TreeMap<String, Integer> toCntMap = new TreeMap<>();
                toCntMap.put(ticket.get(1),1);
                fromToCntMap.put(ticket.get(0),toCntMap);
            }else{
                Map<String, Integer> toCntMap= fromToCntMap.get(ticket.get(0));
                toCntMap.put(ticket.get(1),toCntMap.getOrDefault(ticket.get(1),0)+1);
            }
        }
//        1：注意这两个的初始化啊
        path.add("JFK");
        backTracking("JFK",tickets.size()+1);
        return path;
    }
    public static void main(String[] args){
        L332_250525_1 l3322505251 = new L332_250525_1();
        List<List<String>> tickets=new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        for (String s : l3322505251.findItinerary(tickets)) {
            System.out.println(s);
        }


    }
}
