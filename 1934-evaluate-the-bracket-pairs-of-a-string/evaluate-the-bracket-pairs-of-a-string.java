class Solution {
    public String evaluate(String s, List<List<String>> l) {
        Map<String,String> map = new HashMap<>();
        int size=l.size();
        for(int i=0;i<size;i++){
            map.put(l.get(i).get(0),l.get(i).get(1));
        }
        StringBuffer sb= new StringBuffer();
        int i=0;
        int len = s.length();
        char ch[]=s.toCharArray();
        while(i<len){
            if(ch[i]!='('){
                sb.append(ch[i]);
            }
            else{
                i++;
                StringBuffer st= new StringBuffer();
                while(i<len && ch[i]!=')'){
                     st.append(ch[i]);
                     i++;
                }
                if(map.containsKey(st.toString())){
                    sb.append(map.get(st.toString()));
                }
                else{
                    sb.append('?');
                }
           }
           i++;
        }
        return sb.toString();
    }
}