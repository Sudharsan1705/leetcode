class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int hash1[]=new int[26];
        int n=words2.length;
        for(int i=0;i<n;i++){
            char ch[]=words2[i].toCharArray();
            int hash[]=new int[26];
            for(int j=0;j<ch.length;j++){
               hash[ch[j]-'a']++;
            }
            for(int j=0;j<26;j++){
                hash1[j]=Math.max(hash1[j],hash[j]);
            }
        }
        List<String> l = new ArrayList<>();
        int len=words1.length;
        for(int i=0;i<len;i++){
            char ch[]=words1[i].toCharArray();
            int hash[]=new int[26];
            for(int j=0;j<ch.length;j++){
               hash[ch[j]-'a']++;
            }
            boolean flag=true;
            for(int j=0;j<26;j++){
                if(hash1[j]!=0 && hash1[j]>hash[j]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                l.add(words1[i]);
            }
        }
        return l;
    }
}