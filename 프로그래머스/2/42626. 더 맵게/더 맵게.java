import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }

        int count = 0;
        while (pq.peek() < K) {
            
            if (pq.size() == 1 && pq.peek() < K) {
                return -1;
            }
            
            pq.add(pq.poll() + (pq.poll() * 2));
            count++;
        }

        return count;
    }
}