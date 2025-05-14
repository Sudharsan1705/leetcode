class Solution {
    public int lengthAfterTransformations(String s, int t) {
        long dp[] = new long[26];
        for (int i = 0; i < s.length(); i++) {
            dp[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            long temp = dp[25];
            for (int j = 24; j >= 0; j--) {
                 dp[j+1] = dp[j];
            }
            dp[0] = temp;
            dp[1] += temp%1_00_00_00_007;
        }
        long res = 0;
        for(int i = 0; i < 26;i++){
            res += dp[i];
            res %= 1_00_00_00_007;
        }
        return (int)res;
    }
}