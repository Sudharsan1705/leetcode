class Solution {
    public long calculateScore(String s) {
        long res = 0l;
        char ch[] = s.toCharArray();
        int len = ch.length;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = (char) (122 - ch[i] + 97);
            if (!map.containsKey(ch[i])) {
                map.put(ch[i], new ArrayList<>());
            }
            if (map.containsKey(c) && map.get(c).size() > 0) {
                List<Integer> l = map.get(c);
                res += i - l.get(l.size() - 1);
                l.remove(l.size() - 1);
            }
            else
            map.get(ch[i]).add(i);
        }
        return res;
    }
}