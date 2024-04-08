import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 큐
public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop(queue)).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty(queue)).append("\n");
                    break;
                case "front":
                    sb.append(front(queue)).append("\n");
                    break;
                case "back":
                    queue = back(queue);
                    break;
            }
        }

        String result = sb.toString();
        System.out.println(result);
    }

    private static Queue<Integer> back(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            List<Integer> list = new ArrayList<>();
            Queue<Integer> copy = new LinkedList<>();
            while (!queue.isEmpty()) {
                copy.offer(queue.peek());
                list.add(queue.poll());
            }
            sb.append(list.get(list.size() - 1)).append("\n");
            queue = copy;
        }
        return queue;
    }

    private static int front(Queue<Integer> queue) {
        return queue.isEmpty() ? -1 : queue.peek();
    }

    private static int empty(Queue<Integer> queue) {
        return queue.isEmpty() ? 1 : 0;
    }

    private static int pop(Queue<Integer> queue) {
        return queue.isEmpty() ? -1 : queue.poll();
    }
}
