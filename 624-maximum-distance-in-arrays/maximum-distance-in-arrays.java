class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int res=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int min=arrays.get(i).get(0);
            int max=arrays.get(i).get(arrays.get(i).size()-1);
            if(!set.contains(min) || !set.contains(max)){
               for(int j=i+1;j<n;j++){
                  res=Math.max(res,Math.abs(min-arrays.get(j).get(arrays.get(j).size()-1)));
                  res=Math.max(res,Math.abs(max-arrays.get(j).get(0)));
               }
             set.add(min);
             set.add(max);
            }
        }
        return res;
    }
}