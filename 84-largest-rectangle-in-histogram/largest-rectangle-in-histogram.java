class Solution {
    public int largestRectangleArea(int[] nums) {
        int res=0;
        int n=nums.length;
        int arr[]=new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                int p=st.peek();
                arr[p]=nums[p]*(i-p);
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int p=st.peek();
            arr[p]=nums[p]*(n-p);
            st.pop();
        }
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                int p=st.peek();
                res=Math.max(res,(nums[p]*(p-i-1))+arr[p]);
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int p=st.peek();
            res=Math.max(res,(nums[p]*(p))+arr[p]);
            st.pop();
        }
        return res;
    }
}