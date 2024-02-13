class Solution {
    public boolean pal(String s){
        int n=s.length()/2;
        int l=s.length()-1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=s.charAt(l--))
            return false;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            if(pal(words[i])){
                return words[i];
            }
        }
        return "";
    }
}