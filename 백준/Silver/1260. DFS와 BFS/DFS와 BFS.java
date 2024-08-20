import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int v;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(v);
        bfs(v);

        System.out.println(answer);
    }

    private static void dfs(int v) {

        visited[v] = true;
        answer.append(v).append(" ");

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && arr[v][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {

        Arrays.fill(visited, false); // 방문 배열 초기화

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true; // 정점 방문 처리

        answer.append("\n").append(v).append(" ");

        while (!queue.isEmpty()) {
            int vv = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[vv][i] == 1) {
                    answer.append(i).append(" ");
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
