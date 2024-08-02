import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());


        List<Integer> list = new ArrayList<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            Integer num = null;

            String command = st.nextToken();
            switch (command) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    if (!list.contains(num)) {
                        list.add(num);
                    }
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    if (list.contains(num)) {
                        list.remove(num);
                    }
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if (list.contains(num)) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if (list.contains(num)) {
                        list.remove(num);
                    } else {
                        list.add(num);
                    }
                    break;
                case "all":
                    list.clear();
                    for (int j = 1; j <= 20; j++) {
                        list.add(j);
                    }
                    break;
                case "empty":
                    list.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}
