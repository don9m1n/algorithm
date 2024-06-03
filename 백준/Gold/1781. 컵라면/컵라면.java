import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 컵라면
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<CupRamen> pq = new PriorityQueue<>(new Comparator<CupRamen>() {
            @Override
            public int compare(CupRamen o1, CupRamen o2) {
                if (o1.getDeadLine() == o2.getDeadLine()) {
                    return o2.getCount() - o1.getCount();
                }

                return o1.getDeadLine() - o2.getDeadLine();
            }
        });

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            pq.offer(new CupRamen(deadLine, count));
        }


        PriorityQueue<Integer> selectQueue = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            CupRamen ramen = pq.poll();

            if (ramen.getDeadLine() > selectQueue.size()) {
                selectQueue.offer(ramen.getCount());
            } else {
                if (selectQueue.peek() < ramen.getCount()) {
                    selectQueue.poll();
                    selectQueue.offer(ramen.getCount());
                }
            }
        }

        int answer = 0;
        while (!selectQueue.isEmpty()) {
            answer += selectQueue.poll();
        }

        System.out.println(answer);
    }

    static class CupRamen {
        private final int deadLine; // 데드라인
        private final int count; // 컵라면 개수

        public CupRamen(int deadLine, int count) {
            this.deadLine = deadLine;
            this.count = count;
        }

        @Override
        public String toString() {
            return "CupRamen{" +
                    "deadLine=" + deadLine +
                    ", count=" + count +
                    '}';
        }

        public int getDeadLine() {
            return deadLine;
        }

        public int getCount() {
            return count;
        }
    }
}
