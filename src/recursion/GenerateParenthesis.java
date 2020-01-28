package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * @author gaoyh
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        help("", 0, 0, ans, n);
        return ans;
    }

    private void help(String cur, int left, int right, List<String> ans, int n) {
        if (cur.length() == 2 * n) {
            ans.add(cur);
            return;
        }
        if (left < n) {
            help(cur + "(", left + 1, right, ans, n);
        }
        if (right < left) {
            help(cur + ")", left, right + 1, ans, n);
        }
    }


    public static void main(String[] args) {
        List<String> strings = new GenerateParenthesis().generateParenthesis(3);
        strings.forEach(System.out::println);
    }
}
