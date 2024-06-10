class Solution {
    public int helper(int dp[][],int freA,int A,int n,char c){
        if(freA == n){
            return 0;
        }
        else if(freA > n){
            return 10001;
        }
        else if(dp[freA][A]!=0){
            return dp[freA][A];
        }
        else{
            int copy=10001;
            int paste=10001;
            if(c == 'c')
             copy=1+helper(dp,freA,freA,n,'p');
             if(A!=0)
             paste=1+helper(dp,freA+A,A,n,'c');
             dp[freA][A]=Math.min(copy,paste); 
        }
        return dp[freA][A];
    }
    public int minSteps(int n) {
      int dp[][]=new int[n][n];
      return helper(dp,1,0,n,'c');
    }
}