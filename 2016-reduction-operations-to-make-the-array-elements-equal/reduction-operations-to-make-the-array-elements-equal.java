class Solution {
    public int reductionOperations(int[] nums) {
       int n=nums.length;
       Map<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
       for(int i:nums){
           map.put(i,map.getOrDefault(i,0)+1);
       }
       int size=map.size()-1;
       int sum=0;
       for(int i:map.keySet()){
            sum+=map.get(i)*size;
            size--;
            //System.out.println(sum);
       }
       return sum;
    }
}