package org.bolin.algorithm.backtracking.suiXiangLu.L79exist;

import java.util.Arrays;

class L79exist_250719_1 {
    private final int[][] dir = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
//       1: visited注意重复调用问题
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean dfs(char[][] board, String word, int index, int si, int sj, boolean[][] visited) {

        if (word.charAt(index) == board[si][sj]) {
            visited[si][sj] = true;
//         2:放到里面防止因为越界而导致无法进行下一层问题
            if (index == word.length() - 1) {
                return true;
            }
            for (int i = 0; i < dir.length; i++) {
                int ni = si + dir[i][0];
                int ny = sj + dir[i][1];
                if (ni < 0 || ni >= board.length || ny < 0 || ny >= board[ni].length || visited[ni][ny]) {
                    continue;
                }
                if (dfs(board, word, index + 1, ni, ny, visited)) {
                    return true;
                }
            }
            visited[si][sj] = false;
        }
        return false;

    }

    public static void main(String[] args) {
        L79exist_250719_1 l79exist2507191 = new L79exist_250719_1();
        l79exist2507191.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB");

    }

}


class T250629_1 {
    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //   1：注意不能重复遍历啊
    boolean[][] visited;

    public boolean traversal(char[][] board, int x, int y, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if ((x < 0 || x >= board.length) || (y < 0 || y >= board[0].length) || board[x][y] != word.charAt(index) || visited[x][y]) {
            return false;
        }
        boolean flag = false;
        visited[x][y] = true;
        for (int i = 0; i < dir.length; i++) {

            if (traversal(board, x + dir[i][0], y + dir[i][1], word, index + 1)) {
                flag = true;
            }

        }
        visited[x][y] = false;
        return flag;


    }

    public static char[][] parseCharBoard(String input) {
        // 去除最外层的 []
        input = input.substring(1, input.length() - 1);

        // 分割出每一行
        String[] rows = input.split("],\\[");

        int numRows = rows.length;
        int numCols = rows[0].replaceAll("[\\[\\]\"]", "").split(",").length;

        char[][] board = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            // 去除左右的 " 或 [ ]
            String cleanedRow = rows[i].replaceAll("[\\[\\]\"]", "");
            String[] chars = cleanedRow.split(",");

            for (int j = 0; j < chars.length; j++) {
                board[i][j] = chars[j].charAt(0);
            }
        }

        // 打印结果验证
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        return board;
    }

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
//               2:这里不能visited 的话全部都是false了啊
//                visited[i][j]=true;
                if (traversal(board, i, j, word, 0)) flag = true;
//                visited[i][j]=false;
            }
        }
        return flag;

    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        String str = "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]";
        char[][] chars = parseCharBoard(str);

        T250629_1 t2506291 = new T250629_1();
        boolean abcced = t2506291.exist(chars, "ABCCED");


    }
}

public class L79exist {
}
