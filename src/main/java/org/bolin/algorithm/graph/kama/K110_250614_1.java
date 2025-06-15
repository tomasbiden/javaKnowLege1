package org.bolin.algorithm.graph.kama;

import java.util.*;

public class K110_250614_1 {
        public static int bfs(int start,int end,Map<Integer,List<Integer>>  nodeToNodeMap,int nodeSize){
//            有的节点它
            boolean[] visited=new boolean[nodeSize];
            int len=0;
            LinkedList<Integer> linkedList=new LinkedList<Integer>();
            linkedList.addFirst(start);
            visited[start]=true;
            while (!linkedList.isEmpty()){
                len++;
                int tmpLevelSize=linkedList.size();
                for(int i=0;i<tmpLevelSize;i++){
                    Integer firstNode = linkedList.removeFirst();
                    if(firstNode==end){
                        return len;
                    }
                    List<Integer> nodeToNodeList = nodeToNodeMap.get(firstNode);
                    for(Integer nextNode : nodeToNodeList ){
//                       注意要看有没有访问过的啊
                        if(!visited[nextNode]){
                            linkedList.addLast(nextNode);
                            visited[nextNode]=true;
                        }

                    }



                }
            }
            return 0;

        }

        public static int checkDiffSize(String a,String b){
            int len=0;
            for(int i=0;i<a.length();i++){
                len+=a.charAt(i)!=b.charAt(i)?1:0;
            }
            return len;
        }

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            String beginStr=scanner.next();
            String endStr=scanner.next();
            List<String> wordList=new ArrayList<>();
            wordList.add(beginStr);
            for(int i=0;i<n;i++){
                wordList.add(scanner.next());
            }
            wordList.add(endStr);
//            hashMap 注意初始化
            Map<Integer,List<Integer>>  nodeToNodeMap=new HashMap<>(wordList.size());
            for(int i=0;i<wordList.size();i++){
                for(int j=0;j<wordList.size();j++){
                    if(!nodeToNodeMap.containsKey(i)){
                        nodeToNodeMap.put(i,new ArrayList<>());
                    }
                    if(checkDiffSize(wordList.get(i),wordList.get(j))==1){
                       nodeToNodeMap.get(i).add(j);

                    }

                }
            }
//           2:注意这个-1
            System.out.println(bfs(0,wordList.size()-1,nodeToNodeMap, wordList.size()));
            scanner.close();



        }

}
