class Solution {
    public int largestRectangleArea(int[] nums) {
        int res=0;
        int n=nums.length;
        int arr[]=new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                arr[st.peek()]=nums[st.peek()]*(i-st.peek());
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            arr[st.peek()]=nums[st.peek()]*(n-st.peek());
            st.pop();
        }
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                res=Math.max(res,(nums[st.peek()]*(st.peek()-i))+arr[st.peek()]-nums[st.peek()]);
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            res=Math.max(res,(nums[st.peek()]*(st.peek()+1))+arr[st.peek()]-nums[st.peek()]);
            st.pop();
        }
        return res;
    }
}