class Solution {
    public String stringHash(String s, int k) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i+=k){
           int hash = 0;
           for(int j=i;j<i+k;j++){
            hash+=s.charAt(j)-'a';
           }    
           sb.append((char)(hash%26+'a')); 
        }
        return sb.toString();
    }
}