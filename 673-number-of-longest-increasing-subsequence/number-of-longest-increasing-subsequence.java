class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int val = 0;
        int dp[] = new int[n];
        int ways[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if(dp[i] == 0){
                ways[i] = 1;
            }
            for (int j = i; j < n; j++) {
                if (nums[i] < nums[j] && dp[i] == dp[j] + 1) {
                ways[i] += ways[j];
                }
            }
            val = Math.max(val, dp[i]);
        }
        int res = 0;
        for(int i  = 0 ; i < n ; i++){
            if(dp[i] == val){
                res += ways[i];
            }
        }
        return res;
    }
}