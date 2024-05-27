import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = answer.length - 1; i >= 0; i--) {
            
            while (!stack.isEmpty()) {
                if (stack.peek() > numbers[i]) {
                    answer[i] = stack.peek();
                    break;
                } else {
                    stack.pop();
                }
            }
            
            if (stack.isEmpty()) {
                answer[i] = -1;
            }
            

            stack.push(numbers[i]);
        }

        return answer;
    }
}