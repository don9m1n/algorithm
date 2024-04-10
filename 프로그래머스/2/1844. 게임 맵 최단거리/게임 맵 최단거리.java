import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int n;
    static int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        bfs(0, 0, maps);

        return maps[n - 1][m - 1] == 1 ? -1 :maps[n - 1][m - 1];
    }
    
    private static void bfs(int x, int y, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        maps[nx][ny] = maps[curX][curY] + 1;
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}