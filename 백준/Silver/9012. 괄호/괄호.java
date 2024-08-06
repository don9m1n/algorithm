import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            answer.append(isBracket(br.readLine())).append("\n");
        }

        System.out.println(answer);
    }

    private static String isBracket(String bracket) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < bracket.length(); i++) {
            char ch = bracket.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return "NO";
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}
