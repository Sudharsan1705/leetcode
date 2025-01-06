class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ;i++){
            if(nums[i] < k){
                return -1;
            }
            set.add(nums[i]);
        }
        if(set.contains(k)){
            return set.size()-1;
        }
        return set.size();
    }
}