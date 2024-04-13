import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀의 귀재
public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            System.out.println(isPalindrome(br.readLine()) + " " + count);
            count = 0;
        }
    }

    static int recursion(String word, int start, int end) {
        count++;
        if (start >= end) {
            return 1;
        } else if (word.charAt(start) != word.charAt(end)) {
            return 0;
        } else {
            return recursion(word, start + 1, end - 1);
        }
    }

    static int isPalindrome(String word) {
        return recursion(word, 0, word.length() - 1);
    }
}
