import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주사위
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dice = new int[6];

        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        int[] min = new int[3];
        min[0] = Math.min(dice[0], dice[5]);
        min[1] = Math.min(dice[1], dice[4]);
        min[2] = Math.min(dice[2], dice[3]);

        Arrays.sort(min);

        long[] total = new long[3];
        total[0] = 4L;
        total[1] = 8L * (n - 2) + 4;
        total[2] = 5L * (n - 2) * (n - 2) + 4L * (n - 2);

        if (n == 1) {
            Arrays.sort(dice);
            System.out.println(dice[0] + dice[1] + dice[2] + dice[3] + dice[4]);
        } else {
            System.out.println(total[0] * (min[0] + min[1] + min[2]) + total[1] * (min[0] + min[1]) + total[2] * min[0]);
        }
    }
}
