import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int count = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= n; j++) {
                if (count == 0 && arr[j] == 0) {
                    arr[j] = i;
                    break;
                } else if (arr[j] == 0) {
                    count--;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            answer.append(arr[i]).append(" ");
        }
        
        System.out.println(answer);
    }
}
