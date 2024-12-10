import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (String name : map.keySet()) {
            if(map.get(name) == 1) {
                return name;
            }
        }

        return "";
    }
}