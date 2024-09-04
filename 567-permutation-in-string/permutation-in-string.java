class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int hash[] = new int[26];
        int n = s1.length();
        int len = s2.length();
        char ch[] = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            hash[s1.charAt(i) - 'a']++;
        }
        int i = 0;
        while (i < n && i < len) {
            hash[ch[i] - 'a']--;
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (hash[j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            i++;
        }
        while (i < len) {
            hash[ch[i - n] - 'a']++;
            hash[ch[i] - 'a']--;
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (hash[j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            i++;
        }
        return false;
    }
}