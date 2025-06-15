package org.bolin.algorithm.graph.kama;

import java.util.*;

public class K110_250614_2 {
    public static int bfs(int start, int end, Map<Integer, Set<Integer>> nodeToNodeMap, int nodeSize) {
//            有的节点它
        boolean[] visited = new boolean[nodeSize];
        int len = 0;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.addFirst(start);
        visited[start] = true;
        while (!linkedList.isEmpty()) {
            len++;
            int tmpLevelSize = linkedList.size();
            for (int i = 0; i < tmpLevelSize; i++) {
                Integer firstNode = linkedList.removeFirst();
                if (firstNode == end) {
                    return len;
                }
                Set<Integer> nodeToNodeList = nodeToNodeMap.get(firstNode);
                for (Integer nextNode : nodeToNodeList) {
//                       注意要看有没有访问过的啊
                    if (!visited[nextNode]) {
                        linkedList.addLast(nextNode);
                        visited[nextNode] = true;
                    }

                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String beginStr = scanner.next();
        String endStr = scanner.next();
        List<String> wordList = new ArrayList<>();
        wordList.add(beginStr);
        for (int i = 0; i < n; i++) {
            wordList.add(scanner.next());
        }
        if(!wordList.contains(endStr)){
            // System.out.println(0);
            System.out.println(0);
        }
        wordList.add(endStr);
        HashMap<String, Integer> stringToNodeNumMap = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            stringToNodeNumMap.put(wordList.get(i), i);
        }
        Set<String> strSet = new HashSet<>(wordList);

//      hashMap 注意初始化
        Map<Integer, Set<Integer>> nodeToNodeMap = new HashMap<>(wordList.size());
        for (int i = 0; i < wordList.size(); i++) {
            String str = wordList.get(i);
            char[] charArray = str.toCharArray();
//          j你携程了i
            for (int j = 0; j < charArray.length; j++) {
                char old = charArray[j];
                for (char k = 'a'; k <= 'z'; k++) {
                    charArray[j] = k;
                    String newStr = new String(charArray);
                    if (strSet.contains(newStr)) {
                        if (!nodeToNodeMap.containsKey(i)) {
                            nodeToNodeMap.put(i, new HashSet<>());
                        }
                        nodeToNodeMap.get(i).add(stringToNodeNumMap.get(newStr));
                    }
//             注意复原啊
                    charArray[j]=old;
                }
            }
        }
//           2:注意这个-1
        System.out.println(bfs(0, wordList.size() - 1, nodeToNodeMap, wordList.size()));
        scanner.close();


    }

}
