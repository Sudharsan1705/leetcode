class Solution {
    public int res;

    public void dfs(Map<Integer, List<Integer>> map, int arr[], int val, int prev, int count, Set<Integer> set) {
        if (!map.containsKey(val)) {
            return;
        } else {
            if (arr[val] > 0 && count > arr[val] && set.contains(val)) {
                res = Math.min(res, count - arr[val]);
            }
            if (arr[val] > 0 && count > arr[val]) {
                return;
            } else {
                arr[val] = count;
                set.add(val);
                for (int i : map.get(val)) {
                    if (i != prev)
                        dfs(map, arr, i, val, count + 1, set);
                }
                set.remove(val);
            }
        }
    }

    public int findShortestCycle(int n, int[][] edges) {
        res = 1001;
        int arr[] = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                map.put(edges[i][0], new ArrayList<>());
            }
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            dfs(map, arr, i, i, 1, new HashSet<>());
        }
        return res == 1001 ? -1 : res;
    }
}