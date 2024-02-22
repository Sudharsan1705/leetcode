class Trie {
    Trie arr[];
    boolean isEnd;
    public Trie() {
        arr = new Trie[27];
    }
    public void insert(String word) {
        int n=word.length();
        Trie trav[] = arr;
        for(int i=0;i<n;i++){
            if(trav[word.charAt(i)-'a'] == null)
            trav[word.charAt(i)-'a']=new Trie();
            trav=trav[word.charAt(i)-'a'].arr;
        }
        trav[26]=new Trie();
    }
    
    public boolean search(String word) {
        int n=word.length();
        Trie trav[] = arr;
        for(int i=0;i<n;i++){
            if(trav[word.charAt(i)-'a'] == null)
            return false;
            trav=trav[word.charAt(i)-'a'].arr;
        }
         if(trav[26]!=null){
             return true;
         }
         return false;
    }
    
    public boolean startsWith(String word) {
        int n=word.length();
        Trie trav[] = arr;
        for(int i=0;i<n;i++){
            if(trav[word.charAt(i)-'a'] == null)
            return false;
            trav=trav[word.charAt(i)-'a'].arr;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */