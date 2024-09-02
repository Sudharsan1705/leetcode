class Solution {
    public long check(long dp[][], int num, int x, int pow, int level, int val) {
        if (num == 0) {
            return 1;
        } else if (num < 0 || pow == val) {
            return 0;
        } else if (dp[level][num] != -1) {
            return dp[level][num];
        }
        long take = check(dp, num - (int) Math.pow(pow, x), x, pow + 1, level + 1, val);
        long dont = check(dp, num, x, pow + 1, level + 1, val);
        return dp[level][num] = (take + dont) % 1_00_00_00_007;
    }

    public int numberOfWays(int n, int x) {
        int val = 1;
        while (Math.pow(val, x) <= n) {
            val++;
        }
        long dp[][] = new long[val][n + 1];
        for (int i = 0; i < val; i++){
            Arrays.fill(dp[i], -1);
        }
        return (int) check(dp, n, x, 1, 1, val);
    }
}