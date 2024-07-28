import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(st.nextToken());
        }

        switch (sb.toString()) {
            case "12345678":
                System.out.println("ascending");
                break;
            case "87654321":
                System.out.println("descending");
                break;
            default:
                System.out.println("mixed");
        }
    }
}
