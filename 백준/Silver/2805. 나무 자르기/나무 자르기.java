import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long low = 0;
        long high = max;
        while (high >= low) {

            long sum = 0;
            long mid = (low + high) / 2;

            for (int i = 0; i < n; i++) {
                sum += arr[i] > mid ? arr[i] - mid : 0;
            }

            if (sum < m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(high);
    }
}
