import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 나는 친구가 적다 (Small)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String k = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            }
        }

        if (sb.toString().contains(k)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
