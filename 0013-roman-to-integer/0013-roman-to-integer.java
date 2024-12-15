import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("CM", 900);
        map.put("CD", 400);
        map.put("XC", 90);
        map.put("XL", 40);
        map.put("IX", 9);
        map.put("IV", 4);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int sum = 0;
        for (String key : map.keySet()) {
            while (s.contains(key)) {
                s = s.replaceFirst(key, "");
                sum += map.get(key);
            }
        }

        return sum;
    }
}