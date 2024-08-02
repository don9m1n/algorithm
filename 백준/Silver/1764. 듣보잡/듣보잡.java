import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), i);
        }

        int count = 0;
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();

            if (map.containsKey(name)) {
                answer.add(name);
                count++;
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (String name : answer) {
            sb.append(name).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);

    }
}
