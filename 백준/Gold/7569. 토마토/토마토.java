import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m;
    static int n;
    static int h;
    static int day = 0;

    // 상하좌우 위 아래
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[][][] box;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];
        visited = new boolean[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    
                    if(box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    day = Math.max(day, box[i][j][k]);
                }
            }
        }

        System.out.println(day - 1);



    }

    private static void bfs() {

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int z = curr[0];
            int x = curr[1];
            int y = curr[2];

            // 상하좌우위아래 검색
            for (int i = 0; i < 6; i++) {
                int nh = z + dh[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nh >= 0 && nh < h && nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nh][nx][ny] && box[nh][nx][ny] == 0) {
                        visited[nh][nx][ny] = true;
                        box[nh][nx][ny] = box[z][x][y] + 1;
                        queue.add(new int[]{nh, nx, ny});
                    }
                }
            }
        }
    }
}
