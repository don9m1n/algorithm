class Solution {
    
    static int max = 0;
    static int count = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);

        return max;
    }
    
     private void dfs(int k, int[][] dungeons, int count) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }

        max = Math.max(max, count);
    }
}