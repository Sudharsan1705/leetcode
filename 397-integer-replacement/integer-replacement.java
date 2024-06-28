class Solution {
    Map<Long,Integer> map;
    public int helper(long n){
        if(n == 1){
            return 0;
        }
        else if(map.containsKey(n)){
            return map.get(n);
        }
        else{
            int res=Integer.MAX_VALUE;
            if(n%2 == 0){
              res=1+helper(n/2);
            }
            else{
                res=Math.min(res,1+helper(n+1));
                res=Math.min(res,1+helper(n-1));
            }
            map.put(n,res);
        }
        return map.get(n);
    }
    public int integerReplacement(int n) {
        map = new HashMap<>();
        return helper((long)n);
    }
}