class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = -10000000;
        int i = 0;
        double sum = 0;
        int n = nums.length;
        while(i < k && i < n){
            sum += nums[i];
            i++;
        }
        res = Math.max(sum/k,res);
        System.out.println(res);
        while(i < n){
            sum -= nums[i-k];
            sum += nums[i];
            res = Math.max(res,sum/k);
            i++;
        }
        return res;
    }
}