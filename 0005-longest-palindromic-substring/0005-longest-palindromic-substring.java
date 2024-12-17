class Solution {
    public String longestPalindrome(String s) {
        
        if (s.length() == 1) {
            return s;
        }

        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j + 1);

                if (isPalindrome(str)) {
                    if (str.length() > answer.length()) {
                        answer = str;
                    }
                }
            }
        }

        return answer;
    }

    private  boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}