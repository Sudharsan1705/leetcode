class Solution {
    public int minJumps(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],new HashSet<>());
            }
            map.get(arr[i]).add(i);
        }
        int lev=0;
        Set<Integer> s = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
           int size=q.size();
           while(size-->0){
               int in=q.poll();
               if(in == n-1)
               return lev;
               s.add(in);
               if(in-1>=0 && !s.contains(in-1)){
                   q.add(in-1);
                   s.add(in-1);
               }
               if(in+1<n && !s.contains(in+1)){
                   q.add(in+1);
                   s.add(in+1);
               }
               if(!set.contains(in)){
               Set<Integer> num=map.get(arr[in]);
               for(int i:num){
                   if(!s.contains(i)){
                       q.add(i);
                       set.add(i);
                   }
               }
               }
           }
           lev++;
        }
        return n-1;
    }
}