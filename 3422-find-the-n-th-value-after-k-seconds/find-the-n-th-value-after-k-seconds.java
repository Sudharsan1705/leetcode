class Solution {
    public int valueAfterKSeconds(int n, int k) {
        long arr[]=new long[n];
        int mod=1_00_00_00_007;
        Arrays.fill(arr,1);
        while(k-->0){
            for(int i=1;i<n;i++){
                arr[i]=(arr[i-1]+arr[i])%mod;
            }
        }
        return (int)arr[n-1];
    }
}