import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            if (decompose(i) == n) {
                System.out.println(i);
                break;
            }

            if (i == n) {
                System.out.println(0);
            }
        }
    }

    private static int decompose(int num) {
        int sum = num;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
    
}
