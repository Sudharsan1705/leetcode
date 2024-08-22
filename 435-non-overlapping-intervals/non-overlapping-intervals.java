class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        Arrays.sort(nums, (a, b) -> Integer.compare(a[1],b[1]));
        int val = nums[0][1];
        int n = nums.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
           if(val <= nums[i][0]){
            val = nums[i][1];
           }
           else{
            res++;
           }
        }
        return res;
    }
}