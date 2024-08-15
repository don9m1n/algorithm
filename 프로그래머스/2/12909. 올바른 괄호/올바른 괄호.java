import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (stack.isEmpty() && ch == ')') {
                return false;
            }

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')' && stack.peek() == '(') {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}