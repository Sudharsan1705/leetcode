class Solution {
    public int maximumCandies(int[] candies, long k) {
        long l = 1l, r = 1_00_00_00_00_00_00l ,res = 0l;
        while (l <= r) {
            long mid = (l + r) / 2;
            long val = 0;
            for (int i = 0; i < candies.length; i++) {
               val+=candies[i]/mid;
            }
            if(val >= k){ 
                res = mid;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return (int) res;
    }
}