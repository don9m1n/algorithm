import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            int sum = bfs(i);

            if (sum < min) {
                min = sum;
                index = i;
            }
        }

        System.out.println(index);

    }

    private static int bfs(int v) {

        Arrays.fill(visited, false);
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{v, 1});
        visited[v] = true;
        int sum = 0;

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int vv = poll[0];
            int depth = poll[1];

            for (int i = 1; i <= n; i++) {
                if(!visited[i] && arr[vv][i] == 1) {
                    sum += depth;
                    visited[i] = true;
                    queue.add(new int[]{i, depth + 1});
                }
            }
        }

        return sum;
    }
}
