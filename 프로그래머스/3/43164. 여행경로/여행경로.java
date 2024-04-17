import java.util.*;

class Solution {
    
    static String[][] ticketsCopy;
    static boolean[] visited;
    static List<String> list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        ticketsCopy = tickets;
        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN");

        Collections.sort(list);

        return list.get(0).split(",");
    }
    
    private static void dfs(int depth, String start, String path) {
        if (depth == ticketsCopy.length) {
            list.add(path);
            return;
        }

        for (int i = 0; i < ticketsCopy.length; i++) {
            if (!visited[i] && start.equals(ticketsCopy[i][0])) {
                visited[i] = true;
                dfs(depth + 1, ticketsCopy[i][1], path + "," + ticketsCopy[i][1]);
                visited[i] = false;
            }
        }
    }
}