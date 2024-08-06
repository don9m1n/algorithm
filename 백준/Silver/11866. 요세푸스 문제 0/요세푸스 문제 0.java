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

        int count = 0;
        StringBuilder answer = new StringBuilder("<");
        while (queue.size() > 1) {
            if (count == k - 1) {
                answer.append(queue.poll()).append(", ");
                count = 0;
                continue;
            }

            queue.add(queue.poll());
            count++;
        }

        System.out.println(answer.append(queue.poll()).append(">"));
    }
}
