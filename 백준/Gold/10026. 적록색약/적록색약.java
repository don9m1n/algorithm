import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        String[][] origin = new String[n][n];
        String[][] colorBlind = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split("");

            for (int j = 0; j < arr.length; j++) {
                origin[i][j] = arr[j];
                // 색약 배열은 초록이나 빨강이 나오면 빨강색으로 처리한다.
                colorBlind[i][j] = arr[j].matches("[RG]") ? "R" : arr[j];
            }
        }

        int originZone = search(origin);
        answer.append(originZone).append(" ");

        // 방문 배열 초기화
        for (boolean[] v : visited) {
            Arrays.fill(v, false);
        }

        int blindZone = search(colorBlind);
        answer.append(blindZone).append(" ");

        System.out.println(answer);
    }

    private static int search(String[][] arr) {

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, arr);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int x, int y, String[][] arr) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            x = curr[0];
            y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵을 벗어난 경우에는 다음 좌표로 이동
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                // 방문한 적이 없고, 색깔이 같다면 다음 좌표로 이동
                if (!visited[nx][ny] && arr[x][y].equals(arr[nx][ny])) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
