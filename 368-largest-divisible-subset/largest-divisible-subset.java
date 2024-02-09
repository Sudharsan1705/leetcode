class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
       Arrays.sort(nums);
       int n=nums.length;
       int dp[]=new int[n];
       int pre[]=new int[n];
       dp[0]=1;
       int j=0;
       int max=1;
       int in=0;
       for(int i=1;i<n;i++){
           j=i-1;
           dp[i]=1;
           pre[i]=-1;
          while(j>=0){
             if(nums[i]%nums[j] == 0){
                 if(dp[i]<dp[j]+1){
                     dp[i]=dp[j]+1;
                     pre[i]=j;
                 }
             }
             j--;
          }
          if(max<dp[i]){
              max=dp[i];
              in=i;
          }
       }

       List<Integer> l = new ArrayList<>();
       l.add(nums[in]);
       int val=pre[in];
       while(val>0){
        l.add(nums[val]);
        val=pre[val];
       }
       if(val == 0 && in !=0)
       l.add(nums[val]);
       return l;
    }
}