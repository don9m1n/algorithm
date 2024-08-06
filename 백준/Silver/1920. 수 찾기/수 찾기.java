import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Long, Integer> map1 = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            map1.put(Long.parseLong(st.nextToken()), i);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Map<Integer, Long> map2 = new LinkedHashMap<>();
        for (int i = 0; i < m; i++) {
            map2.put(i, Long.parseLong(st.nextToken()));
        }

        StringBuilder answer = new StringBuilder();
        for (Integer key : map2.keySet()) {
            answer.append(map1.containsKey(map2.get(key)) ? 1 : 0).append("\n");
        }

        System.out.println(answer);
    }
}
