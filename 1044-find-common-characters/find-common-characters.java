class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int hash[] = new int[26];
        int n = words.length;
        for (char c : words[0].toCharArray()) {
            hash[c - 'a']++;
        }
        for (int i = 1; i < n; i++) {
            int arr[] = new int[26];
            for (char c : words[i].toCharArray()) {
                arr[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                hash[j]=Math.min(hash[j],arr[j]);
            }
        }
        for(int i=0;i<26;i++){
            while(hash[i]>0){
                char ch=(char)(i+'a');
                result.add(String.valueOf(ch));
                hash[i]--;
            }
        }
        return result;
    }
}