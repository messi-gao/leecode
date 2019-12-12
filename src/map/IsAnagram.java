package map;

import java.util.HashMap;
import java.util.Map;

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