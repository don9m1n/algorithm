import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String word = br.readLine();
            answer.append(word.charAt(0)).append(word.charAt(word.length() - 1)).append("\n");
        }

        System.out.println(answer);
    }
}
