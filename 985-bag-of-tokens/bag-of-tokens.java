class Solution {
    public int bagOfTokensScore(int[] nums, int power) {
     Arrays.sort(nums);
     int l=0;
     int r=nums.length-1;
     int res=0;
     int max=0;
     while(l<=r){
        if(power>=nums[l]){
            res++;
            power-=nums[l];
            l++;
            max=Math.max(res,max);
        }
        else{
            if(res>0){
            power+=nums[r];
            res--;
            r--;
            }
            else{
                break;
            }
        }
     }   
     return max;
    }
}