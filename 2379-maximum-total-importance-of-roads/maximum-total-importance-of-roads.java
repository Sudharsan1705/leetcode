class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long hash[]=new long[n];
        for(int i=0;i<roads.length;i++){
            hash[roads[i][0]]++;
            hash[roads[i][1]]++;
        }
        Arrays.sort(hash);
        long res=0l;
        for(int i=n-1;i>=0;i--){
           res+=(hash[i]*n);
           n-=1;
        }
        return res;
    }
}