import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 정점 번호

        arr = new int[n + 1][n + 1]; // 5x2 크기의 인접 행렬
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(v);
        System.out.println(sb);
        Arrays.fill(visited, false);
        bfs(v);
    }

    private static void dfs(int v) {
        visited[v] = true;

        sb.append(v).append(" ");
        for (int i = 1; i < arr.length; i++) {
            if (!visited[i] && arr[v][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int vv = queue.poll();
            sb.append(vv).append(" ");

            for (int i = 1; i < arr.length; i++) {
                if (!visited[i] && arr[vv][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println(sb);
    }
}
