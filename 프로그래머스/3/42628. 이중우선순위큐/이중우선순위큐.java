import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (String operation : operations) {
            String command = operation.split(" ")[0];
            int number = Integer.parseInt(operation.split(" ")[1]);

            switch (command) {
                case "I":
                    if (number >= 0) {
                        pq1.add(number);
                    } else {
                        pq2.add(number);
                    }
                    break;
                case "D":
                    if (number == 1) {
                        if (pq1.isEmpty()) {
                            while (pq2.size() > 1) {
                                pq1.add(pq2.poll());
                            }
                            pq2.poll();
                        } else {
                            pq1.poll();
                        }
                    } else {
                        if (pq2.isEmpty()) {
                            while (pq1.size() > 1) {
                                pq2.add(pq1.poll());
                            }
                            pq1.poll();
                        } else {
                            pq2.poll();
                        }
                    }
                    break;
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!pq1.isEmpty()) {
            list.add(pq1.poll());
        }

        while (!pq2.isEmpty()) {
            list.add(pq2.poll());
        }

        Collections.sort(list);

        if (!list.isEmpty()) {
            answer[0] = list.get(list.size() - 1);
            answer[1] = list.get(0);
        }

        return answer;
    }
}