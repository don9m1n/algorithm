import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 화살표 그리기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> graph = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.add(new int[]{x, y});
        }

        graph.sort((o1, o2) -> {

            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = graph.get(i);
            int pos = arr[0]; // 위치
            int color = arr[1]; // 색깔

            if (i == 0) { // 첫 지점이고
                if (color == graph.get(i + 1)[1]) { // 다음 지점과 동일 색상이면 거리 재기
                    sum += graph.get(i + 1)[0] - pos;
                }
            } else if (i == n - 1) {
                sum += pos - graph.get(i - 1)[0];
            } else {
                if (color != graph.get(i + 1)[1]) { // 다음 지점과 색이 다르면
                    sum += pos - graph.get(i - 1)[0];
                } else {
                    if (color != graph.get(i - 1)[1]) { // 이전 지점과 색이 다르면
                        sum += graph.get(i + 1)[0] - pos;
                    } else {
                        sum += Math.min(pos - graph.get(i - 1)[0], graph.get(i + 1)[0] - pos);
                    }
                }
            }
        }
        System.out.println(sum);

    }

}
