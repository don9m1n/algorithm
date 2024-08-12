import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                draw(i, j);
            }
        }

        System.out.println(min);
    }

    private static void draw(int x, int y) {

        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        char color = board[x][y]; // 첫 번째 칸의 색상

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (board[i][j] != color) {
                    count++;
                }

                color = color == 'W' ? 'B' : 'W';
            }

            color = color == 'W' ? 'B' : 'W';
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
