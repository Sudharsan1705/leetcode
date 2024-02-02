class Solution {
    public boolean canConstruct(String s, int k) {
       int even=0;
       int odd=0;
       int hash[]=new int[26];
       char ch[]=s.toCharArray();
       int n=ch.length;
       if(k>n){
           return false;
       }
       for(int i=0;i<n;i++){
           hash[ch[i]-'a']++;
       } 
       for(int i=0;i<26;i++){
           even+=hash[i]/2;
           odd+=hash[i]%2;
       }
       //System.out.println(odd+" "+even);
       if(odd>k){
          return false;
       }
       return true;
    }
}