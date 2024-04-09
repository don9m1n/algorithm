import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단지 번호 붙이기
public class Main {

    static Queue<int[]> queue = new LinkedList<>();
    // 상좌하우
    static int[] dx = {-1 , 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n;
    static int houseNum = 0; // 단지 번호
    static Map<Integer, Integer> house = new HashMap<>();
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - 48;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int cnt = bfs(i, j); // 각 단지별 집의 개수
                    house.put(houseNum, cnt);
                }
            }
        }
        System.out.println(result());
    }

    private static String result() {
        StringBuilder sb = new StringBuilder();
        sb.append(house.size()).append("\n");

        List<Integer> list = new ArrayList<>(house.values());
        Collections.sort(list);
        for (Integer l : list) {
            sb.append(l).append("\n");
        }

        return sb.toString();
    }

    private static int bfs(int x, int y) {
        int cnt = 1;
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        cnt++;
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        houseNum++;
        return cnt;
    }
}