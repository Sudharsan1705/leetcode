class Solution {
    public int pivotInteger(int n) {
       int pre[]=new int[n];
       pre[0]=1;
       for(int i=1;i<n;i++){
        pre[i]=pre[i-1]+i+1;
       }
       int sum=0;
       for(int i=n;i>0;i--){
          sum+=i;
          if(sum == pre[i-1]){
              return i;
          }
       }
       return -1;
    }
}