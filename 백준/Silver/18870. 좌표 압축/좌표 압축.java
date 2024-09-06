import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] copy = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            copy[i] = arr[i];
        }

        Arrays.sort(copy);

        Map<Integer, Integer> map = new HashMap<>();

        // 좌표 압축: 각 원소에 순위를 매기는 것 (낮은 값이 순위가 높음)
        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], rank++);
            }
        }

        for (int i = 0; i < n; i++) {
            answer.append(map.get(arr[i])).append(" ");
        }

        System.out.println(answer);
    }
}
