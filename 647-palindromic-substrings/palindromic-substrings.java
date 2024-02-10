class Solution {
    public int countSubstrings(String s) {
        char ch[]=s.toCharArray();
        int n=ch.length;
        int res=0;
        for(int i=0;i<n;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=i;j<n;j++){
              sb.append(ch[j]);
              StringBuffer st = new StringBuffer(sb);
              String str=st.reverse().toString();
             // System.out.println(str+" "+sb);
              if(str.equals(sb.toString())){
                  res++;
              }
            }
        }
        return res;
    }
}