import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static String[][] arr;
    static boolean[][] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[n][m];
        visited = new boolean[n][m];

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {

            String[] words = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                arr[i][j] = words[j];
                if (words[j].equals("I")) {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);
        System.out.println(count == 0 ? "TT" : count);

    }

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny]) {
                        // 사람을 만난 경우 count++ 하고 큐에 위치 저장
                        if (arr[nx][ny].equals("P")) {
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            count++;
                        }

                        // 벽이 아닌 경우 큐에 위치 저장
                        if (arr[nx][ny].equals("O")) {
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }
}
