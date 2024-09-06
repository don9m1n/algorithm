import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int day;
    static int[][] box;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        visited = new boolean[n][m];

        List<int[]> coordinate = new ArrayList<>(); // 초기 토마토들의 좌표

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1) {
                    coordinate.add(new int[]{i, j});
                }
            }
        }

        bfs(coordinate);

        // 익지 않은 토마토가 있는 경우 -1 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        
        System.out.println(day - 1);

    }

    private static void bfs(List<int[]> list) {

        Queue<int[]> queue = new LinkedList<>();

        for (int[] coordinate : list) {
            int x = coordinate[0];
            int y = coordinate[1];

            queue.offer(new int[]{x, y});
            visited[x][y] = true;
        }

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            day = Math.max(day, box[cx][cy]);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && box[nx][ny] == 0) {
                        box[nx][ny] = box[cx][cy] + 1;
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
