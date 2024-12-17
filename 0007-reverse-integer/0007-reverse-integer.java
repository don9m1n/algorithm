class Solution {
    public int reverse(int x) {
        long reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse <= Integer.MIN_VALUE || reverse >= Integer.MAX_VALUE - 1 ? 0 : (int) reverse;
    }
}