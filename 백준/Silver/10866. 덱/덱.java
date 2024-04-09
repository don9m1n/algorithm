import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 덱
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> deque = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push_front":
                    deque.add(0, Integer.parseInt(command[1]));
                    break;
                case "push_back":
                    deque.add(Integer.parseInt(command[1]));
                    break;
                case "pop_front":
                    int removeFront = deque.size() == 0 ? -1 : deque.remove(0);
                    System.out.println(removeFront);
                    break;
                case "pop_back":
                    int removeBack = deque.size() == 0 ? -1 : deque.remove(deque.size() - 1);
                    System.out.println(removeBack);
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    int empty = deque.isEmpty() ? 1 : 0;
                    System.out.println(empty);
                    break;
                case "front":
                    int front = deque.size() == 0 ? -1 : deque.get(0);
                    System.out.println(front);
                    break;
                case "back":
                    int back = deque.size() == 0 ? -1 : deque.get(deque.size() - 1);
                    System.out.println(back);
                    break;
            }
        }
    }
}
