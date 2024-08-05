import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        String word = br.readLine();

        double sum = 0;
        for (int i = 0; i < l; i++) {
            sum += (word.charAt(i) - 96) * Math.pow(31, i);
        }

        System.out.println((int) (sum % 1234567891));
    }
}
