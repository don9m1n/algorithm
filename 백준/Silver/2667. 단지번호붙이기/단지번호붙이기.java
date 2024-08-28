import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        
        // 우선순위 큐에 넣으면 오름차순 정렬 할 필요가 없음
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문한 적 없고, 집이 있는 위치가 나오면 bfs 검색 시작
                if (!visited[i][j] && map[i][j] == 1) {
                    pq.offer(bfs(i, j));
                }
            }
        }

        answer.append(pq.size()).append("\n");

        while (!pq.isEmpty()) {
            answer.append(pq.poll()).append("\n");
        }

        System.out.println(answer);
    }

    private static int bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        visited[x][y] = true;

        int count = 1;
        
        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int cx = curr[0];
            int cy = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
