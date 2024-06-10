import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팰린드롬인지 확인하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int length = word.length() - 1;
        int answer = 1;
        for (int i = 0; i < Math.sqrt(word.length()); i++) {
            char left = word.charAt(i);
            char right = word.charAt(length - i);

            if (left != right) {
                answer = 0;
                break;
            }
        }

        System.out.println(answer);
    }
}
