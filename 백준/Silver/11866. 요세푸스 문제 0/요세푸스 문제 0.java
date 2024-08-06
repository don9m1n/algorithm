import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder answer = new StringBuilder("<");
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }

            answer.append(queue.poll()).append(", ");
        }

        System.out.println(answer.append(queue.poll()).append(">"));
    }
}
