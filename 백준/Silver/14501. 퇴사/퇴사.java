import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] counsel = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            counsel[i][0] = Integer.parseInt(st.nextToken());
            counsel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int t = counsel[i][0]; // 상담에 걸리는 시간
            int p = counsel[i][1]; // 상담을 했을 때 얻는 수익

            if (i + t <= n) {
                dp[i] = Math.max(dp[i + 1], dp[i + t] + p);
            } else {
                dp[i] = Math.max(dp[i], dp[i + 1]);
            }
        }

        System.out.println(dp[0]);

    }
}
