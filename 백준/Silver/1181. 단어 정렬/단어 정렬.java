import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (!words.contains(word)) {
                words.add(word);
            }
        }

        words.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }

            return o1.length() - o2.length();
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
