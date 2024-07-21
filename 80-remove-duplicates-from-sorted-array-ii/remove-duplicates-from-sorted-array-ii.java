class Solution {
    public int removeDuplicates(int[] nums) {
        int res=0;
        int in=0,n=nums.length,in1=0;
        while(in<n){
            int val=nums[in];
            int count=0;
            while(in<n && val == nums[in]){
                in++;
                count++;
            }
            count=Math.min(count,2);
            res+=count;
            while(count>0){
                nums[in1++]=val;
                count--;
            }
        }
        return res;
    }
}