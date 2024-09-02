import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < r; i++) {
            answer.append("*".repeat(c)).append("\n");
        }

        System.out.println(answer);
    }
}
