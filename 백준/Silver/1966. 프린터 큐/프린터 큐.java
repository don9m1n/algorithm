import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                queue.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int[] document = queue.poll(); // 현재 문서 정보

                boolean flag = true;
                for (int[] q : queue) {
                    if (q[1] > document[1]) {
                        queue.add(document);
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    count++;

                    if (m == document[0]) {
                        answer.append(count).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
