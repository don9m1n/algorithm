import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long max = 0;
        int[] cable = new int[k];
        for (int i = 0; i < k; i++) {
            cable[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, cable[i]);
        }

        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {

            mid = (max + min) / 2;

            long count = 0;

            for (int i = 0; i < cable.length; i++) {
                count += (cable[i] / mid);
            }

            if(count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
