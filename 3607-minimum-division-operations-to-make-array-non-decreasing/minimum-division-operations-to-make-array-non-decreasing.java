class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int val = 0;
            if (nums[i + 1] >= nums[i]) {
                continue;
            }
            if (nums[i] % 2 == 0) {
                val = 2;
            } else {
                int k = (int) Math.sqrt(nums[i]);
                for (int j = k; j >= 2; j--) {
                    if (nums[i] % j == 0 && nums[i + 1] >= j) {
                        val = j;
                        break;
                    }
                }
            }
            if (val != 0) {
                res++;
                nums[i] = val;
            } else {
                return -1;
            }
        }
        return res;
    }
}