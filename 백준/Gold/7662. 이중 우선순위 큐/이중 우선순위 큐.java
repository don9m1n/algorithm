import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            StringTokenizer st;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                char command = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (command == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (command == 'D') {
                    if (!map.isEmpty()) {

                        int key = 0;
                        if (n == 1) {
                            key = map.lastKey();
                        } else {
                            key = map.firstKey();
                        }

                        map.put(key, map.get(key) - 1);
                        if (map.get(key) == 0) {
                            map.remove(key);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}
