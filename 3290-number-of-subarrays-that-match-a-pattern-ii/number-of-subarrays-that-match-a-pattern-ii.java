class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n=nums.length;
        int pnums[] = new int[n];
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]) pnums[i]=1;
            if(nums[i] < nums[i-1]) pnums[i]=-1;
        }
        int p[] = findKMP(pattern);
        int i=1;
        int j=0;
        int res=0;
        System.out.println(Arrays.toString(pnums));
        System.out.println(Arrays.toString(p));
        while(i<n){
            if(pnums[i] == pattern[j]){
                i++;
                j++;
            }
            else if(j == 0){
                i++;
            }
            else{
                j=p[j-1];
            }
           if( j == p.length){
                j=p[j-1];
                res++;
            }
        }
        return res;
    }
    public int[] findKMP(int arr[]){
        int in=0;
        int p[]=new int[arr.length];
        int i=1;
        int n=arr.length;
        while(i<n){
            if(arr[i] == arr[in]){
                p[i]=++in;
                i++;
            }
            else if(in == 0){
                i++;
            }
            else{
                in=p[in-1];
            }
        }
        return p;
    }
}