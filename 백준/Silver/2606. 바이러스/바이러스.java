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
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        bfs(1);

        System.out.println(count);

    }

    private static void bfs(int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        visited[v] = true;

        while (!queue.isEmpty()) {

            int vv = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[vv][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
}
