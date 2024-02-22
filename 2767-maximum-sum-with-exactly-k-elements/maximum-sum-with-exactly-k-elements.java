class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int val=max+k;
        return (val*(val-1))/2-(max*(max-1))/2;
    }
}