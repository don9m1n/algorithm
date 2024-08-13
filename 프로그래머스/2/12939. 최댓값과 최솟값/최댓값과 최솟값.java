class Solution {
    public String solution(String s) {
        
        StringBuilder answer = new StringBuilder();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String num : s.split(" ")) {
            min = Math.min(min, Integer.parseInt(num));
            max = Math.max(max, Integer.parseInt(num));
        }

        return answer.append(min).append(" ").append(max).toString();
    }
}