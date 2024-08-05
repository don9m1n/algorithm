import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        String word = br.readLine();

        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < l; i++) {
            result = result.add(BigInteger.valueOf(word.charAt(i) - 96).multiply(BigInteger.valueOf(31).pow(i)));
        }

        System.out.println(result.mod(BigInteger.valueOf(1234567891)));
    }
}
