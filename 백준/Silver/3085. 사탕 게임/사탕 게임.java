import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 사탕 게임
public class Main {

    static int n;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 오른쪽 사탕과 교환
                if (j + 1 < n && board[i][j] != board[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    max = Math.max(max, checkMax());
                    swap(i, j, i, j + 1);
                }
                // 아래쪽 사탕과 교환
                if (i + 1 < n && board[i][j] != board[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, checkMax());
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(max);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    private static int checkMax() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 0; i < n - 1; i++) {
                if (board[i][j] == board[i + 1][j]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }

}
