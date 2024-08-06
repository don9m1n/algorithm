import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] p = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            p[i] = new Point(x, y);
        }

        Arrays.sort(p, (o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }

            return o1.x - o2.x;
        });

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(p[i]);
        }

        System.out.println(answer);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y + "\n";
        }
    }
}
