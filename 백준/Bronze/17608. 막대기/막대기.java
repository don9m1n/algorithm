import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 막대기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 1;
        int standard = arr[n];
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] > standard) {
                count++;
                standard = arr[i];
            }
        }

        System.out.println(count);
    }

}
