package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
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
