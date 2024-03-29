class Solution {
    public long backtrack(Long dp[],int start,int zero,int one){
        if(start == 0){
            return 1l;
        }
        else if(start<0){
            return 0l;
        }
        else if(dp[start]!=null){
            return dp[start];
        }
        else{
            dp[start]=(backtrack(dp,start-zero,zero,one)+backtrack(dp,start-one,zero,one))%1_00_00_00_007;
        }
        return dp[start];
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        Long dp[]=new Long[high+1];
        long ans=0l;
        while(low<=high){
            backtrack(dp,low,zero,one);
            ans+=(dp[low]);
            ans%=1_00_00_00_007;
            low++;
        }
        return (int)ans;
    }
}