class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        int res = -1;
        int start[] = new int[n + 2];
        int end[] = new int[n + 2];
        Map<Integer, Integer> fre = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            if (end[val - 1] != 0 && start[val + 1] != 0) {
                int fre1 = end[val - 1] - start[val - 1] + 1;
                int fre2 = end[val + 1] - start[val + 1] + 1;
                fre.put(fre1, fre.getOrDefault(fre1, 0) - 1);
                fre.put(fre2, fre.getOrDefault(fre2, 0) - 1);
                fre.put((fre1 + fre2 + 1), fre.getOrDefault((fre1 + fre2 + 1), 0) + 1);
                start[end[val + 1]] = start[val - 1];
                end[start[val - 1]] = end[val + 1];
            } else if (end[val - 1] != 0) {
                int fre1 = end[val - 1] - start[val - 1] + 1;
                fre.put(fre1, fre.getOrDefault(fre1, 0) - 1);
                end[start[val - 1]] = val;
                start[val] = start[start[val - 1]];
                end[val] = val;
                fre.put(fre1 + 1, fre.getOrDefault(fre1 + 1, 0) + 1);
            } else if (start[val + 1] != 0) {
                int fre1 = end[val + 1] - start[val + 1] + 1;
                fre.put(fre1, fre.getOrDefault(fre1, 0) - 1);
                end[val] = end[end[val + 1]];
                start[end[val + 1]] = val;
                start[val] = val;
                fre.put(fre1 + 1, fre.getOrDefault(fre1 + 1, 0) + 1);
            } else {
                start[val] = val;
                end[val] = val;
                fre.put(1, fre.getOrDefault(1, 0) + 1);
            }
            if (fre.containsKey(m) && fre.get(m) > 0) {
                res = i + 1;
            }
        }
        return res;
    }
}