import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 단어 뒤집기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String str = br.readLine();

            StringBuilder sb = new StringBuilder();
            for (int j = str.length() - 1; j >= 0; j--) {
                sb.append(str.charAt(j));
            }

            String[] arr = sb.toString().split(" ");
            sb = new StringBuilder();
            for (int j = arr.length - 1; j >= 0; j--) {
                sb.append(arr[j]).append(" ");
            }

            System.out.println(sb);
        }
    }
}
