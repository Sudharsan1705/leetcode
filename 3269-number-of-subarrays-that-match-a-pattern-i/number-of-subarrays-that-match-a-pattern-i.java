class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
       int res=0;
       int n=nums.length;
       int len=pattern.length;
       for(int i=0;i<n-len;i++){
           int val=0;
           int j=0;
          while(j<len){
              if(nums[i+j+1]<nums[i+j]){
                  val=-1;
              }
               if(nums[i+j+1] == nums[i+j]){
                  val=0;
              }
               if(nums[i+j+1]>nums[i+j]){
                  val=1;
              }
              if(pattern[j]!=val){
                  break;
              }
              if(pattern[j] == val){
                  j++;
              }
          }
           if(j == len){
               res++;
           }
       }
        return res;
    }
}