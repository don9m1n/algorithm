import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점 개수
        m = Integer.parseInt(st.nextToken()); // 간선 개수

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        if (m == 0) {
            System.out.println(n);
            return;
        }

        int count = 0;
        for (int i = 1; i <= n ; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void bfs(int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        visited[v] = true;

        while (!queue.isEmpty()) {

            int vv = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[vv][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

    }
}
