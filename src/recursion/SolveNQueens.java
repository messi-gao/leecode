package recursion;

import java.util.*;

/**
 * 51. N皇后
 *
 * @author gaoyh
 */
public class SolveNQueens {
    private Set<Integer> pieSet = new HashSet<>();
    private Set<Integer> naSet = new HashSet<>();
    private Set<Integer> colSet = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return res;
        }
        helper(0, n, new ArrayList<>());
        return res;
    }

    public void helper(int row, int n, List<String> list) {
        for (int col = 0; col < n; col++) {
            if (row == n) {
                res.add(list);
                break;
            }
            if (pieSet.contains(row + col) || naSet.contains(row - col) || colSet.contains(col)) {
                continue;
            }

            pieSet.add(row + col);
            naSet.add(row - col);
            colSet.add(col);

            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[col] = 'Q';
            ArrayList<String> objects = new ArrayList<>();
            objects.addAll(list);
            objects.addAll(Collections.singletonList(new String(chars)));
            helper(row + 1, n, objects);

            pieSet.remove(row + col);
            naSet.remove(row - col);
            colSet.remove(col);
        }
    }

    public static void main(String[] args) {
        new SolveNQueens().solveNQueens(4);
    }
}
