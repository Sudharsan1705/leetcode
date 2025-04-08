class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int val = 0, res = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 2) {
                val++;
            }
        }
        int in = 0;
        while (val > 0) {
            int count = 0;
            while (count < 3) {
                if (in < n && map.get(nums[in]) == 2) {
                    val--;
                }
                if (in < n)
                    map.put(nums[in], map.get(nums[in]) - 1);
                in++;
                count++;
            }
            res++;
        }
        return res;
    }
}