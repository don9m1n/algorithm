import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken()); // 시
        int m = Integer.parseInt(st.nextToken()); // 분

        StringBuilder sb = new StringBuilder();
        if (m - 45 >= 0) {
            sb.append(h).append(" ").append(m - 45);
        } else { // m - 45 < 0
            if (h == 0) {
                sb.append(23).append(" ").append(15 + m);
            } else {
                sb.append(h - 1).append(" ").append(15 + m);
            }
        }

        System.out.println(sb);
    }

}
