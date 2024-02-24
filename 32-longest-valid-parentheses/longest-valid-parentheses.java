class Solution {
    public int longestValidParentheses(String s) {
       Stack<Character> st = new Stack<>();
       Stack<Integer> num = new Stack<>();
       char ch[]=s.toCharArray();
       int n=ch.length;
       int count=0;
       int res=0;
       num.push(0);
       for(int i=0;i<n;i++){
         if(st.isEmpty() && ch[i] == ')'){
             num.pop();
             num.push(0);
         }
         else if(ch[i] == '('){
             st.push(ch[i]);
             num.push(0);
         }
         else{
             if(st.peek() == '('){
                int val=num.pop();
                int val2=num.pop();
                num.push(val2+val+2);
                st.pop();
             }
         }
         res=Math.max(res,num.peek());
       }
       return res;
    }
}