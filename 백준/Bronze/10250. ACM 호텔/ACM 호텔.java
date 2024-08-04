import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[][] hotel = new int[h + 1][w + 1];

            for (int j = 1; j <= h; j++) {
                for (int k = 1; k <= w; k++) {
                    hotel[j][k] = j * 100 + k;
                }
            }

            StringBuilder sb = new StringBuilder();
            int count = 1;

            loop:
            for (int j = 1; j <= w; j++) {
                for (int k = 1; k <= h; k++) {
                    if (count == n) {
                        sb.append(hotel[k][j]);
                        break loop;
                    }
                    count++;
                }
            }

            System.out.println(sb);
        }
    }
}
