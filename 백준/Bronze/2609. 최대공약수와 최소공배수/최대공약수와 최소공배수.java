import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int gcd = 0;
        int lcm = 0;

        int a = Math.max(x, y);
        int b = Math.min(x, y);
        while (true) {

            if (a % b == 0) {
                gcd = b;
                break;
            }

            int r = a % b;
            a = b;
            b = r;
        }

        lcm = gcd * (x / gcd) * (y / gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

}
