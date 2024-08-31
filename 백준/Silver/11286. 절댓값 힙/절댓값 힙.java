import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }

            return Math.abs(o1) - Math.abs(o2);
        });

        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                answer.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.offer(num);
            }
        }

        System.out.println(answer);
    }
}
