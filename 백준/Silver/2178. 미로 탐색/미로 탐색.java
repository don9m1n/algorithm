import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {

            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - 48;
            }
        }

        bfs();
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny] || maze[nx][ny] == 0) {
                    continue;
                }

                queue.offer(new int[]{nx, ny});
                maze[nx][ny] = maze[x][y] + 1;
                visited[nx][ny] = true;
            }
        }

        System.out.println(maze[n - 1][m - 1]);
    }
}
