import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> pokemon1 = new LinkedHashMap<>();
        Map<String, Integer> pokemon2 = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String pokemon = br.readLine();
            pokemon1.put(i + 1, pokemon);
            pokemon2.put(pokemon, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String problem = br.readLine();

            if (problem.charAt(0) >= '0' && problem.charAt(0) <= '9') {
                sb.append(pokemon1.get(Integer.parseInt(problem))).append("\n");
            } else {
                sb.append(pokemon2.get(problem)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
