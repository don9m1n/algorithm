import java.util.Stack;

class Solution {
    boolean solution(String s) {
                Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 첫 번째 괄호가 닫는 괄호인 경우에는 성립 불가능
            if (i == 0 && ch == ')') {
                return false;
            }

            if (ch == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}