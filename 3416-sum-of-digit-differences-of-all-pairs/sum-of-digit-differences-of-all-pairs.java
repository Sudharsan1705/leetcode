class Solution {
    public long sumDigitDifferences(int[] nums) {
        long res=0l;
        int num=nums[0];
        int len=0;
        while(num>0){
            num/=10;
            len++;
        }
        int arr[][]=new int[len][10];
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            int in=0;
            while(val>0){
                arr[in++][val%10]++;
                val/=10;
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<10;j++){
                if(arr[i][j]!=0)
                for(int k=j+1;k<10;k++){
                    if(arr[i][k]!=0){
                        res+=(arr[i][j]*arr[i][k]);
                    }
                }
            }
        }
        return res;
    }
}