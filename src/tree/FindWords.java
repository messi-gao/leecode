package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(board, res, visited, "", i, j, trie);
            }
        }
        return new ArrayList<>(res);
    }

    private void helper(char[][] board, Set<String> res, boolean[][] visited, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        str += board[x][y];
        if (!trie.startsWith(str)) {
            return;
        }
        if (trie.search(str)) {
            res.add(str);
        }
        visited[x][y] = true;
        helper(board, res, visited, str, x - 1, y, trie);
        helper(board, res, visited, str, x + 1, y, trie);
        helper(board, res, visited, str, x, y - 1, trie);
        helper(board, res, visited, str, x, y + 1, trie);
        visited[x][y] = false;
    }

    public static void main(String[] args) {

    }
}
