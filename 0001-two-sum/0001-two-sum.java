class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int value = target - map.get(i);

            for (int key : map.keySet()) {
                if (key != i && map.get(key) == value) {
                    return new int[]{i, key};
                }
            }
        }

        return new int[]{};
    }
}