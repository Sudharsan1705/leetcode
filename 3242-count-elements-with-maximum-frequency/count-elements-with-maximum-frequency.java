class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n=nums.length;
        int max=0;
        int res=0;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i:map.keySet()){
            int val=map.get(i);
            if(max<val){
                max=val;
                res=val;
            }
            else if(max==val){
                res+=val;
            }
        }
     return res;
    }
}