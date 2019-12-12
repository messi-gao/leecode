package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
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
