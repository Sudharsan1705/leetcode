class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
      Arrays.sort(hand);
      Map<Integer,Integer> map = new LinkedHashMap<>();
      for(int i=0;i<hand.length;i++){
        map.put(hand[i],map.getOrDefault(hand[i],0)+1);
      }
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