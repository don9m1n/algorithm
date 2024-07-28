import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer EOF 불가!
        String input;
        while((input = br.readLine()) != null) {
            int num1 = Integer.parseInt(input.split(" ")[0]);
            int num2 = Integer.parseInt(input.split(" ")[1]);

            System.out.println(num1 + num2);
        }
    }
}
