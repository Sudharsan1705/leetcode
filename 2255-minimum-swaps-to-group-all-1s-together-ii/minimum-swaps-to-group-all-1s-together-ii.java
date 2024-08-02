class Solution {
    public int minSwaps(int[] nums) {
        int oneCount=0;
        int i=0,max=0;
        int n=nums.length;
        while(i<n){
           if(nums[i] == 1)
            oneCount++;
            i++;
        }
        int one=0,fro=0,res=n;
        i=0;
        while(i<oneCount){
            if(nums[i]==1)
            one++;
            i++;
        }
        fro=one;
        res=Math.min(oneCount-one,res);
        while(i<n){
            if(nums[i]==1)
            one++;
            if(nums[i-oneCount]==1)
            one--;
            res=Math.min(oneCount-one,res);
            i++;
        }
        i=oneCount-1;
        while(i>=0){
            if(nums[i] == 1){
                fro--;
            }
            if(nums[--n] == 1){
                fro++;
            }
            res=Math.min(res,oneCount-fro);
            i--;
        }
        return res;
    }
}