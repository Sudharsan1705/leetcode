class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        int dp[] = new int[n];
        for(int i = n-1 ; i >= 0 ; i--){
            dp[i] = arr[i][1];
            for(int j = i+1;j < n; j++){
                if(arr[i][0] == arr[j][0] || arr[i][1]<=arr[j][1]){
                   dp[i] = Math.max(dp[i],arr[i][1]+dp[j]);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}