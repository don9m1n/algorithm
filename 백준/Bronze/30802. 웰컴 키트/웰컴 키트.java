import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (arr[i] % t == 0) {
                count += arr[i] / t;
            } else if (arr[i] > 0 && arr[i] <= t) {
                count += 1;
            } else if (arr[i] > t) {
                count += (arr[i] / t) + 1;
            }
        }

        System.out.println(count);
        System.out.println(n / p + " " + n % p);
    }
}
