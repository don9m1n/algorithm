import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String ox = br.readLine();

            int totalScore = 0;
            int cumulate = 1;
            for (int j = 0; j < ox.length(); j++) {
                if (ox.charAt(j) == 'O') {
                    totalScore += cumulate;
                    cumulate++;
                } else {
                    cumulate = 1;
                }
            }

            sb.append(totalScore).append("\n");
        }

        System.out.println(sb);
    }
}
