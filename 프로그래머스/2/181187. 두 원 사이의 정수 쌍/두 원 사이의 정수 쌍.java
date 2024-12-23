class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long ro1 = (long)Math.pow(r1,2);
        long ro2 = (long)Math.pow(r2,2);
        long ans = 0;

        for(long x = 0; x <= r2; x++) {
            long y2 = (long) Math.sqrt(ro2 - x * x);
            long y1 = (long) Math.sqrt(ro1 - x * x);
            if (Math.sqrt(ro1 - x * x) % 1 == 0) {
                ans++;
            }

            answer += (y2-y1) * 4;
        }

        answer += ans * 4;
        return answer - 4;
    }
}