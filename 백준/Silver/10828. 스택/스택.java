import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        answer.append(-1).append("\n");
                    } else {
                        answer.append(stack.pop()).append("\n");
                    }
                    break;
                case "size":
                    answer.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        answer.append(1).append("\n");
                    } else {
                        answer.append(0).append("\n");
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        answer.append(-1).append("\n");
                    } else {
                        answer.append(stack.peek()).append("\n");
                    }
                    break;
            }
        }

        System.out.println(answer);
    }
}
