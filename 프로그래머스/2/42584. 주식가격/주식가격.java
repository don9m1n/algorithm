import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.add(price);
        }

        List<Integer> answer = new ArrayList<>();

        while(!queue.isEmpty()) {

            int curr = queue.poll();
            int count = 0;
            
            for (int price : queue) {
                count++;
                
                if (curr > price) {
                    break;
                }
            }

            answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}