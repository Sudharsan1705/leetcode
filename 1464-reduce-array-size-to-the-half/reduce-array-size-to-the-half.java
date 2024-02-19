class Solution {
    public int minSetSize(int[] arr) {
       Map<Integer,Integer> map = new HashMap<>();
       int n=arr.length;
       for(int i=0;i<n;i++){
           map.put(arr[i],map.getOrDefault(arr[i],0)+1);
       } 
       PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
       for(int i:map.keySet()){
           q.add(map.get(i));
       }
       int size=0;
       int res=0;
       while(!q.isEmpty()){
           if(size>=(n/2)){
               return res;
           }
           size+=q.poll();
           res++;
       }
       return res;
    }
}