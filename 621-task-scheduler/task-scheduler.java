class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
          map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->  b[1]-a[1]);
        for(char i:map.keySet()){
            p.add(new int[]{i,map.get(i),0});
        }
        int in=1;
        while(p.size()>0){
         PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->  b[1]-a[1]);
         while(p.size()>0){
            int arr[]=p.poll();
            if(arr[2] == 0 || in-arr[2]>n){
                arr[2]=in;
                arr[1]-=1;
                if(arr[1]!=0){
                    p.add(arr);
                }
                break;
            }
            q.add(arr);
         }
         p.addAll(q);
         in++;
        }
        return in-1;
    }
}