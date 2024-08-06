import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            map.put(i, Integer.parseInt(st.nextToken()));
        }

        StringBuilder answer = new StringBuilder();
        for (Integer key : map.keySet()) {
            answer.append(set.contains(map.get(key)) ? 1 : 0).append("\n");
        }

        System.out.println(answer);
    }
}
