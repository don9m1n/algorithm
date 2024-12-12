import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {

            int date = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);

            if(!q.isEmpty() && q.peek() < date) {
                answer.add(q.size());
                q.clear();
            }

            q.add(date);
        }

        answer.add(q.size());

        return answer.stream().mapToInt(i -> i).toArray();
    }
}