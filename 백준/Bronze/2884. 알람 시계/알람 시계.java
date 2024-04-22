import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알람 시계
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m - 45 < 0) {
            m = 60 + m - 45;
            h = h == 0 ? 23 : h - 1;
        } else {
            m = m -45;
        }

        System.out.println(h + " " + m);
    }
}
