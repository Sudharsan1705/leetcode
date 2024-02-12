class Solution {
    public int partitionDisjoint(int[] nums) {
        int n=nums.length;
        int premax[]=new int[n];
        int sufmin[]=new int[n];
        premax[0]=nums[0];
        for(int i=1;i<n;i++){
            premax[i]=Math.max(nums[i],premax[i-1]);
        }
        int min=nums[n-1];
        int ans=1;
        for(int i=n-2;i>=0;i--){
            if(min>=premax[i]){
              ans = i+1;
            }
            min=Math.min(min,nums[i]);
        }
        return ans;
    }
}