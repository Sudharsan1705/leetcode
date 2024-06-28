class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int sufMin[]=new int[n];
        int val=prices[0];
        int res=0;
        sufMin[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            if(i == n-2){
                sufMin[i]=prices[i];
            }
            else
            sufMin[i]=Math.min(sufMin[i+1],prices[i]);
        }
        for(int i=1;i<n;i++){
           if(val>=prices[i]){
            val=prices[i];
           }
           else{
            if(sufMin[i]<=prices[i]){
                res+=prices[i]-val;
                val=prices[i];
            }
           }
        }
        return res;
    }
}