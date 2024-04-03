import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// RGB 거리
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        // 2번집 ~ 3번집의 최소 비용 검사
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(arr[i][0] + dp[i - 1][1], arr[i][0] + dp[i - 1][2]);
            dp[i][1] = Math.min(arr[i][1] + dp[i - 1][0], arr[i][1] + dp[i - 1][2]);
            dp[i][2] = Math.min(arr[i][2] + dp[i - 1][0], arr[i][2] + dp[i - 1][1]);
        }

        int[] costs = dp[n - 1];

        int min = Integer.MAX_VALUE;
        for (int cost : costs) {
            min = Math.min(min, cost);
        }

        System.out.println(min);
    }
}
