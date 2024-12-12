import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue1.add(progresses[i]);
            queue2.add(speeds[i]);
        }

        List<Integer> answer = new ArrayList<>();

        while (!queue1.isEmpty()) {

            for (int i = 0; i < queue1.size(); i++) {
                int speed = queue2.poll();
                queue1.add(queue1.poll() + speed);
                queue2.add(speed);
            }

            int count = 0;
            while (!queue1.isEmpty() && queue1.peek() >= 100) {
                queue1.poll();
                queue2.poll();
                count++;
            }

            if (count > 0) {
                answer.add(count);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}