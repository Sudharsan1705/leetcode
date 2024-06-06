class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
      Map<Integer,Integer> map = new HashMap<>();
      for(int i=0;i<hand.length;i++){
        map.put(hand[i],map.getOrDefault(hand[i],0)+1);
      }
      Map<Integer,Integer> sort = new TreeMap<>(map);
      map = new LinkedHashMap<>(sort);
      while(map.size()>0){
          int count=0;
          int val=0;
          for(int i:map.keySet()){
            val=i;
            break;
          }
          while(map.containsKey(val) && count<groupSize){
            map.put(val,map.get(val)-1);
            if(map.get(val) == 0){
                map.remove(val);
            }
            val++;
            count++;
          }
          if(count != groupSize){
            return false;
          }
      } 
      return true;
    }
}