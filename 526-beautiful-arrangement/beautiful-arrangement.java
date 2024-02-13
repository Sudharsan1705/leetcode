class Solution {
    int res;
    public void back(int start,int end,Set<Integer> set){
      //  System.out.println(set);
        if(start >end){
            res++;
        }
        for(int i=1;i<=end;i++){
            if(!set.contains(i) && ( i%start ==0 || start%i == 0)){
                set.add(i);
                back(start+1,end,set);
                set.remove(i);
            }
        }
    }
    public int countArrangement(int n) {
        res=0;
        back(1,n,new HashSet<>());
        return res;
    }
}