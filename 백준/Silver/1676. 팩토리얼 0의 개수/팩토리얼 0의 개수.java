import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger result = factorial(Integer.parseInt(br.readLine()));

        int count = 0;
        while (result.compareTo(BigInteger.ZERO) > 0) {

            if (result.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
                count++;
            } else {
                break;
            }

            result = result.divide(BigInteger.TEN);
        }

        System.out.println(count);
    }

    private static BigInteger factorial(int n) {
        if (n == 1 || n == 0) {
            return BigInteger.ONE;
        }

        return factorial(n - 1).multiply(BigInteger.valueOf(n));
    }
}
