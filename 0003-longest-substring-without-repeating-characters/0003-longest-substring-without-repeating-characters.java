import java.util.Stack;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        StringBuilder sub = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sub.append(ch);

            for (int j = i + 1; j < s.length(); j++) {
                if (sub.toString().contains(String.valueOf(s.charAt(j)))) {
                    break;
                }

                sub.append(s.charAt(j));
            }

            max = Math.max(max, sub.length());
            sub.setLength(0);
        }

        return max;
    }
}