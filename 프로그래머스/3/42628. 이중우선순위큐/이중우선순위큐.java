import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {

            String[] commands = operation.split(" ");
            String command = commands[0];
            int num = Integer.parseInt(commands[1]);

            switch (command) {
                case "I":
                    minQueue.add(num);
                    maxQueue.add(num);
                    break;
                case "D":
                    if(!maxQueue.isEmpty()) {
                        if (num == 1) {
                            minQueue.remove(maxQueue.poll());
                        } else {
                            maxQueue.remove(minQueue.poll());
                        }
                    }
                    break;
            }
        }

        int[] answer = new int[2];

        if(!(minQueue.isEmpty() || maxQueue.isEmpty())) {
            answer[0] = maxQueue.peek();
            answer[1] = minQueue.peek();
        }

        return answer;
    }
}