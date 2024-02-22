class Solution {
    public boolean canReorderDoubled(int[] arr) {
      Map<Integer,Integer> map = new HashMap<>();
      for(int i:arr){
          map.put(i,map.getOrDefault(i,0)+1);
      }
      Arrays.sort(arr);
      if(map.containsKey(0)){
          if(map.get(0)%2!=0){
              return false;
          }
      }
      map.remove(0);
   //   System.out.println(Arrays.toString(arr));
      for(int i:arr){
     // System.out.println(map);
         if(map.containsKey(i)){
             int val=2*i;
             if(i<0){
                 if(i%2!=0){
                     return false;
                 }
              val=i/2;
             }
             if(!map.containsKey(val))
             return false;
             int num1=map.get(i);
             int num2=map.get(val);
             if(num1>num2){
                 return false;
             }
             if(num1 == num2){
                 map.remove(i);
                 map.remove(val);
             }
             else{
                 map.remove(i);
                 map.put(val,num2-num1);
             }
         }
      }
     // System.out.println(map);
      if(map.size()>0){
          return false;
      }
      return true;
    }
}