class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k-->0){
            int in = 0;
            for(int i = 0;i < nums.length; i++){
                if(nums[in] > nums[i]){
                    in = i;
                }
            }
            nums[in]*=multiplier;
        }
        return nums;
    }
}