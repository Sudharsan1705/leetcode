class Solution {
    public int maxSatisfaction(int[] nums) {
        Arrays.sort(nums);
        int pos=0;
        int possum=0;
        int negsum=0;
        int neg=0;
        int max=0;
        int n=nums.length;
        for(int i=n-1;i>=0;i--){
            pos+=possum;
            neg+=negsum;
            if(nums[i]>=0){
                possum+=nums[i];
                pos+=nums[i];
            }
            else{
                negsum+=nums[i];
                neg+=nums[i];
            }
            max=Math.max(pos+neg,max);
        }
        return max;
    }
}