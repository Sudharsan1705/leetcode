class Solution {
    public String reorganizeString(String s) {
        char ch[] = s.toCharArray();
        int hash[] = new int[26];
        for (int i = 0; i < ch.length; i++) {
            hash[ch[i] - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (hash[i] > 0)
                p.add(new int[] { i, hash[i] });
        }
        int pre = -1;
        while (!p.isEmpty()) {
            int arr[] = p.poll();
            if (arr[0] != pre) {
                sb.append((char) (arr[0] + 97));
                pre = arr[0];
                if (arr[1] > 1) {
                    arr[1] -= 1;
                    p.add(arr);
                }
            } else {
                if (p.isEmpty()) {
                    return "";
                } else {
                    int arr2[] = p.poll();
                    sb.append((char) (arr2[0] + 97));
                    pre = arr2[0];
                    if (arr2[1] > 1) {
                        arr2[1] -= 1;
                        p.add(arr2);
                    }
                    p.add(arr);
                }
            }
        }
        return sb.toString();
    }
}