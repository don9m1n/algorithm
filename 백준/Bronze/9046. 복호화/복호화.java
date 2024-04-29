import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 복호화
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int[] alphabet = new int[26];
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if(ch != ' ') {
                    alphabet[ch - 97]++;
                }
            }

            int max = 0;
            char answer = ' ';
            for (int j = 0; j < alphabet.length; j++) {
                if(alphabet[j] == 0) continue;

                if (alphabet[j] > max) {
                    max = Math.max(max, alphabet[j]);
                    answer = (char) (97 + j);
                }
            }

            Arrays.sort(alphabet);
            
            answer = alphabet[25] == alphabet[24] ? '?' : answer;
            System.out.println(answer);
        }
    }
}
