package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 *
 * @author gaoyh
 */
public class Solution {
    static HashMap<String, String> map = new HashMap<>();

    static {
        map.put("}", "{");
        map.put("]", "[");
        map.put(")", "(");
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("[]"));
    }

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        if (s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            if (map.containsValue(key)) {
                stack.push(key);
            } else if (!stack.empty() && !stack.pop().equals(map.get(key))) {
                return false;
            }
        }
        return stack.empty();
    }
}
