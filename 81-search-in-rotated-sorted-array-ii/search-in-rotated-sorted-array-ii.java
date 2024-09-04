class Solution {
    public boolean binarySearch(int nums[],int target,int l,int r){
        if(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return true;
            }
            else{
                if((nums[l]<target && nums[mid]<target && nums[r]<target) || (nums[mid]>target && nums[r]>target && nums[l]>target)){
                    return binarySearch(nums,target,l,mid-1) || binarySearch(nums,target,mid+1,r);
                }
                else if((nums[mid]<target && nums[r]<target) || (nums[mid]>target && nums[r]>target) || (nums[mid]>target && nums[r]<target)){
                    return binarySearch(nums,target,l,mid-1);
                }
                else{
                    return binarySearch(nums,target,mid+1,r);
                }
            }
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        int l = 0 , r = nums.length-1;
        return binarySearch(nums,target,0,nums.length-1);
    }
}