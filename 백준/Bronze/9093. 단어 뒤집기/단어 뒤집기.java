import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단어 뒤집기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb;
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();

            while (st.hasMoreTokens()) {
                String next = st.nextToken();
                for(int j = next.length() - 1; j >= 0; j--){
                    sb.append(next.charAt(j));
                }

                sb.append(" ");
            }

            System.out.println(sb);
        }
    }
}
