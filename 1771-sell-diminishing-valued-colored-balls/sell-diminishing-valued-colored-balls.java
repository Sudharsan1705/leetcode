class Solution {
    public int maxProfit(int[] nums, int order) {
        Arrays.sort(nums);
        long res = 0l;
        int mod = 1_00_00_00_007;
        int n = nums.length;
        long lev = 1;
        for (int i = n - 1; i > 0; i--) {
            long val1 = (nums[i] - nums[i - 1]);
            long val2 = nums[i];
            long tot = val1 * lev;
            val1 = nums[i] - val1;
            val1 = (val1 * (val1 + 1)) / 2;
            val2 = (val2 * (val2 + 1)) / 2;
            if (order > tot) {
                res += ((val2 - val1) * lev) % mod;
                res = res % mod;
                order -= tot;
            } else {
                long val = order / lev;
                long rem = order % lev;
                val1 = nums[i] - val;
                val1 = (val1 * (val1 + 1)) / 2;
                res += ((val2 - val1) * lev) % mod;
                res = res % mod;
                val1 = (nums[i] - val);
                res += (val1 * rem) % mod;
                res = res % mod;
                order = 0;
                break;
            }
            lev++;
        }
        if (order > 0) {
            long val1 = nums[0];
            long val = order / lev;
            long rem = order % lev;
            if (val > 0) {
                val1 = nums[0] - val;
                val1 = (val1 * (val1 + 1)) / 2;
                long val2 = nums[0];
                val2 = (val2 * (val2 + 1)) / 2;
                res += ((val2 - val1) * lev) % mod;
                res = res % mod;
            }
            val1 = (nums[0] - val);
            res += (val1 * rem) % mod;
            res = res % mod;
        }
        return (int) res;
    }
}