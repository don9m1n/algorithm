import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int i = 1;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            while (true) {
                if (stack.isEmpty() || !stack.peek().equals(poll)) {
                    answer.append("+").append("\n");
                    stack.push(i++);
                } else if (stack.peek().equals(poll)) {
                    answer.append("-").append("\n");
                    stack.pop();
                    break;
                }

                if (stack.peek() > poll) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println(answer);
    }
}
