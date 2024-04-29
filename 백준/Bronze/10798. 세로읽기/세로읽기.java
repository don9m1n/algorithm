import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 세로 읽기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        int maxLength = 0;
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            maxLength = Math.max(maxLength, str.length());
            list.add(str);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            for (String s : list) {
                if (s.length() > i) {
                    sb.append(s.charAt(i));
                }
            }
        }

        System.out.println(sb);
    }

}
