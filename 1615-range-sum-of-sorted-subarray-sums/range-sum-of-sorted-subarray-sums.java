class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int size=(n*(n+1))/2;
        int arr[]=new int[size];
        int in=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
               sum+=nums[j];
               arr[in++]=sum;
            }
        }
        Arrays.sort(arr);
        long res=0l;
        for(int i=left-1;i<right;i++){
            res+=arr[i];
            res%=1_00_00_00_007;
        }
        return (int)res;
    }
}