class Solution {
    public int countTriplets(int[] arr) {
        int res = 0;
        int n = arr.length;
        int val1=0;
        int val2=0;
        for(int i=0;i<n;i++){
            val1=0;
            for(int j=i+1;j<n;j++){
                val1^=arr[j-1];
                val2=0;
                for(int k=j;k<n;k++){
                   val2^=arr[k];
                   if(val1 == val2){
                    res++;
                   }
                }
            }
        }
        return res;
    }
}