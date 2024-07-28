import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 회문
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String word = br.readLine();
            if (isPalindrome(word, 0, word.length() - 1)) {
                System.out.println(0);
            } else if (isPseudoPalindrome(word)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }

        }
    }

    private static boolean isPseudoPalindrome(String word) {

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                if (isPalindrome(word, left + 1, right)) {
                    return true;
                } else if (isPalindrome(word, left, right - 1)) {
                    return true;
                } else {
                    return false;
                }
            }

            left++;
            right--;
        }

        return false;
    }

    private static boolean isPalindrome(String word, int left, int right) {

        while (left < right) {

            // 두 알파벳이 다르면 팰린드롬 성립 불가! 유사 회문 검사하러 ㄱㄱ
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
