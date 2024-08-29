import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);

        System.out.println(arr[k]);
    }

    private static void bfs(int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        arr[v] = 0;

        while (!queue.isEmpty()) {

            int vv = queue.poll();

            if (vv == k) {
                break;
            }

            if (vv + 1 <= 100000 && arr[vv + 1] == 0) {
                arr[vv + 1] = arr[vv] + 1;
                queue.offer(vv + 1);
            }

            if (vv - 1 >= 0 && arr[vv - 1] == 0) {
                arr[vv - 1] = arr[vv] + 1;
                queue.offer(vv - 1);
            }

            if (vv * 2 <= 100000 && arr[vv * 2] == 0) {
                arr[vv * 2] = arr[vv] + 1;
                queue.offer(vv * 2);
            }

        }
    }
}
