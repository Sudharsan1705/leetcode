class Solution {
    public int fun(int nums[],int k){
         int res=0;
       Map<Integer,Integer> map = new HashMap<>();
       int l=0;
       int r=0;
       int n=nums.length;
       while(r<n){
        map.put(nums[r],map.getOrDefault(nums[r],0)+1);
        while(map.size()>k && l<=r)
        {
            map.put(nums[l],map.getOrDefault(nums[l],0)-1);
            if(map.get(nums[l]) == 0){
                map.remove(nums[l]);
            }
            l++;
        }
        res+=(r-l+1);
        r++;
       } 
       return res;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
      return fun(nums,k)-fun(nums,k-1);
    }
}