class Solution {
    public int numberOfSubstrings(String s, int k) {
        char ch[] = s.toCharArray();
        int hash[] = new int[26];
        int l = 0, r = 0, n = ch.length, res = 0;
        while (r < n) {
            hash[ch[r] - 'a']++;
            boolean flag = false;
            while (!flag) {
                int count = 0;
                for (int i = 0; i < 26; i++) {
                    if (hash[i] >= k) {
                        count++;
                    }
                }
                if (count > 0) {
                    res += n - r;
                    hash[ch[l] - 'a']--;
                    l++;
                } else {
                    flag = true;
                }
            }
            r++;
        }
        return res;
    }
}