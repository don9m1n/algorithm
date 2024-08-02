import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        /**
         * (막대 높이 - 낮에 올라가는 높이) 이상까지 올라오면 다음날 정상에 도착이 가능함.
         * 하루에 올라갈 수 있는 높이는 (올라가는 높이 - 미끄러지는 높이)
         * 올림((막대 높이 - 낮에 올라가는 높이) / 하루에 올라갈 수 있는 높이) + 1
         */

        System.out.println((int) Math.ceil((double) (v - a) / (a - b)) + 1);
    }
}
