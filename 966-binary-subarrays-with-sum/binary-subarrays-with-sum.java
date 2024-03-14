class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
      Map<Integer,Integer> map = new HashMap<>();
      int n=nums.length;
      int res=0;
      map.put(0,1);
      int sum=0;
      for(int i=0;i<n;i++){
            sum+=nums[i];
            if(map.containsKey(sum-goal)){
                res+=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
      }  
      return res;
    }
}