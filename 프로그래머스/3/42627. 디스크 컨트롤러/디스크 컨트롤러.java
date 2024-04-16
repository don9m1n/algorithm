import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int sum = 0;
        int time = 0;
        int index = 0;
        int count = 0;

        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.add(jobs[index]);
                index++;
            }

            if (pq.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] poll = pq.poll();
                sum += poll[1] + time - poll[0];
                time += poll[1];
                count++;
            }
        }

        return sum / jobs.length;
    }
}