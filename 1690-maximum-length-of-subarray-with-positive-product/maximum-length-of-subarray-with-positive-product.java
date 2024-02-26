class Solution {
    public int getMaxLen(int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;
        int fn = -1;
        int rn = -1;
        int res = 0;
        int count = 0;
        while (r < n) {
            if (nums[r] == 0) {
                if (count % 2 == 0) {
                    res = Math.max(res, (r - l));
                } else {
                    res = Math.max(res, (r - fn - 1));
                    res = Math.max(res, (rn - l));
                }
                fn = r;
                rn = r;
                l=r+1;
                count = 0;
            } else if (nums[r] < 0) {
                if (fn < l) {
                    fn = r;
                    rn = r;
                } else {
                    rn = r;
                }
                count++;
            }
            r++;
        }
        if (count % 2 == 0) {
            res = Math.max(res, (r - l));
        } else {
            res = Math.max(res, (r - fn - 1));
            res = Math.max(res, (rn - l ));
        }
        return res;
    }
}