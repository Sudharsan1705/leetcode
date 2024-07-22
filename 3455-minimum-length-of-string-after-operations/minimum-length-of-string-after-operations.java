class Solution {
    public int minimumLength(String s) {
        char ch[]=s.toCharArray();
        int n=s.length();
        int hash[]=new int[26];
        for(int i=n-1;i>=0;i--){
            hash[ch[i]-'a']++;
        }
        int lhash[]=new int[26];
        int len=n;
        for(int i=0;i<n;i++){
            hash[ch[i]-'a']--;
            if(lhash[ch[i]-'a']>0 && hash[ch[i]-'a']>0){
                lhash[ch[i]-'a']--;
                hash[ch[i]-'a']--;
                len-=2;
            }
            lhash[ch[i]-'a']++;
        }
        return len;
    }
}