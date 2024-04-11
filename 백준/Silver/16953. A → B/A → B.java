import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A → B
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 0;
        while (b != a) {
            if(b < a || ((b % 2 != 0) && (b % 10 != 1))) {
                System.out.println(-1);
                return;
            }
            if (b % 2 == 0) {
                b /= 2;
            } else {
                b /= 10;
            }
            count++;
        }
        System.out.println(count + 1);
    }
}
