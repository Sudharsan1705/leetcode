class Solution {
    public int minElement(int[] nums) {
        int val = 37;
        for(int i = 0 ; i < nums.length ;i++ ){
             int ele = nums[i];
             int sum = 0;
             while(ele > 0){
               sum += ele%10;
               ele /= 10;
             }
             if(sum < val)
             val = sum;
        }
        return val;
    }
}