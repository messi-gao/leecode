package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 */
class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return getCountMap(s).equals(getCountMap(t));
    }

    private Map<String, Integer> getCountMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.compute(String.valueOf(s.charAt(i)), (key, value) -> value == null ? 1 : value + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("catca", "tacc"));
    }
}