class Solution {
    public int maximumPossibleSize(int[] nums) {
        int val = nums[0];
        int res = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (val <= nums[i]) {
                val = nums[i];
            } else if (val > nums[i]) {
                res--;
            }
        }
        return res;
    }
}