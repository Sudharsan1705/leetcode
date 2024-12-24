class Solution {
    public int traverse(int dp[][],int n1,int n2,int i,int j,int nums1[],int nums2[]){
        if(i == n1 || j == n2){
          return 0;
        }
        else if(dp[i][j] != -1){
            return dp[i][j];
        }
        else{
            if(nums1[i] == nums2[j]){
                dp[i][j] = 1+traverse(dp,n1,n2,i+1,j+1,nums1,nums2);
            }
            else{
                dp[i][j] = Math.max(traverse(dp,n1,n2,i+1,j,nums1,nums2),traverse(dp,n1,n2,i,j+1,nums1,nums2));
            }
        }
        return dp[i][j];
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int dp[][] = new int[n1][n2];
        for(int i= 0; i < n1 ;i++){
            Arrays.fill(dp[i],-1);
        }
        return traverse(dp,n1,n2,0,0,nums1,nums2);
    }
}