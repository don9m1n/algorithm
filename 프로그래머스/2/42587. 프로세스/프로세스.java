import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
            pq.add(priorities[i]);
        }

        int answer = 0;
        while(!queue.isEmpty()) {

            int[] current = queue.poll();

            boolean flag = false;
            if (pq.peek() > current[1]) {
                queue.add(current);
                flag = true;
            }

            if (!flag) {
                pq.poll();
                priorities[current[0]] = -1;
                answer++;

                if (current[0] == location) {
                    return answer;
                }
            }
        }

        return -1;
    }
}