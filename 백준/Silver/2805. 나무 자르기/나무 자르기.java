import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long answer = 0;
        long low = 0;
        long high = arr[n - 1];
        while (true) {
            
            long sum = 0;
            long mid = (low + high) / 2;

            for (int i = 0; i < n; i++) {
                sum += Math.max(0, arr[i] - mid);
            }

            if (sum >= m) {
                if (low > high) {
                    answer = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
