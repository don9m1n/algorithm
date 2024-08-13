class Solution {
    boolean solution(String s) {
        
        int p = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            p += s.toLowerCase().charAt(i) == 'p' ? 1 : 0;
            y += s.toLowerCase().charAt(i) == 'y' ? 1 : 0;
        }

        return p == y;
    }
}