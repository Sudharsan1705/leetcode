class Solution {
    Integer dp[][]=null;
    public int traverse(Map<Integer,List<int[]>> map,int src,int dst,int count ,int k){
        long max=10000000;
        if(src == dst){
            return 0;
        }
        if(count > k ){
            return 10000000;
        }
        else if(dp[src][count]!=null){
            return dp[src][count];
        }
        else{
            long p=0;
            List<int[]> l=map.get(src);
         //   System.out.println(l+" "+count);
            for(int[] a:l){
              p=a[1]+traverse(map,a[0],dst,count+1,k);
              max=Math.min(max,p);
            }
        }
        return dp[src][count]=(int)max;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        dp=new Integer[n][k+1];
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            map.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
     //   System.out.println(map);
        int res=traverse(map,src,dst,0,k);
        if(res == 10000000){
            return -1;
        }
        else{
            return res;
        }
    }     
}