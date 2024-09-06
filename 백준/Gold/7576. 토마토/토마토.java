import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int day = 0;
    static int[][] box;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                day = Math.max(day, box[i][j]);

                // 익지 않은 토마토가 있는 경우에는 -1 출력
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day - 1);

    }

    private static void bfs() {
        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && box[nx][ny] == 0) {
                        box[nx][ny] = box[x][y] + 1;
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
