import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // i를 1로 만드는 최소 연산의 개수
        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, Math.min(dp[i / 2] + 1, dp[i / 3] + 1));
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        
        System.out.println(dp[n]);
    }
}
