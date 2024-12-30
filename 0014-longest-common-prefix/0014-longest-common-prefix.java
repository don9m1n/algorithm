import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        int index = 0;
        while (index < strs[0].length()) {

            char firstWord = strs[0].charAt(index);
            char lastWord = strs[strs.length - 1].charAt(index);

            if (firstWord != lastWord) {
                return strs[0].substring(0, index);
            }

            index++;
        }

        return strs[0];
    }
}