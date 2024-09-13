class Solution {
    public void dfs(Map<Integer, List<Integer>> map, int ele, Set<Integer> visited) {
        if (visited.contains(ele)) {
            return;
        }
        visited.add(ele);
        if (map.containsKey(ele)) {
            for (int i : map.get(ele)) {
                dfs(map, i, visited);
            }
        }
    }

    public long countPairs(int n, int[][] edges) {
        int total = n;
        long res = 0l;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int val1 = edges[i][0];
            int val2 = edges[i][1];
            if (!map.containsKey(val1)) {
                map.put(val1, new ArrayList<>());
            }
            if (!map.containsKey(val2)) {
                map.put(val2, new ArrayList<>());
            }
            map.get(val1).add(val2);
            map.get(val2).add(val1);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                long size = visited.size();
                dfs(map, i, visited);
                long newSize = visited.size() - size;
                res += (total - newSize) * newSize;
                total -= newSize;
            }
        }
        return res;
    }
}