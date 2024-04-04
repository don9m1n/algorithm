import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 팰린드롬
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());

            String[] arr = new String[k];
            for (int j = 0; j < k; j++) {
                arr[j] = br.readLine();
            }
            
            if (k == 1) {
                System.out.println("0");
                continue;
            }
            
            boolean flag = false;
            loop:
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < k; l++) {
                    if (j == l) continue;

                    String str = arr[j] + arr[l];
                    if (isPalindrome(str)) { // 팰린드롬이면 리턴
                        flag = true;
                        System.out.println(str);
                        break loop;
                    }
                }
            }

            if (!flag) {
                System.out.println("0");
            }
        }
    }

    private static boolean isPalindrome(String str) {

        int last = str.length() - 1;
        for (int k = 0; k < str.length() / 2; k++, last--) {
            if (str.charAt(k) != str.charAt(last)) {
                return false;
            }
        }

        return true;
    }
}
