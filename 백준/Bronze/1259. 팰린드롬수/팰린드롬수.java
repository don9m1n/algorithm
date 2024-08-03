import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String word;
        while (!(word = br.readLine()).equals("0")) {
            if (isPalindrome(word)) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isPalindrome(String input) {

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) == input.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

}
