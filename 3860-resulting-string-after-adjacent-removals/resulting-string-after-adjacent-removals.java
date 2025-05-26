class Solution {
    public String resultingString(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n;i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }
            else{
                if(Math.abs(st.peek()-s.charAt(i)) == 1 ||(st.peek() == 'z' && s.charAt(i) == 'a') || (st.peek() == 'a' && s.charAt(i) == 'z')){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}