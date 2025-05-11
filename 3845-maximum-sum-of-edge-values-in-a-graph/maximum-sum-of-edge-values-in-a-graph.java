class Solution {
    boolean check;
    int count;

    public void traverse(Map<Integer, Set<Integer>> map, Set<Integer> v, int pre, int end) {
        if (v.contains(end)) {
            check = true;
        } else if (map.containsKey(end)) {
            count++;
            v.add(end);
            for (int i : map.get(end)) {
                if (count == 1 || pre != i)
                    traverse(map, v, end, i);
            }
        }
    }

    public long maxScore(int num, int[][] edges) {
        long n = num;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                map.put(edges[i][0], new HashSet<>());
            }
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new HashSet<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> v = new HashSet<>();
        List<Integer> cycle = new ArrayList<>();
        List<Integer> noCycle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            check = false;
            count = 0;
            traverse(map, v, i, i);
            if (check) {
                if (count > 0)
                    cycle.add(count);
            } else {
                if (count > 0)
                    noCycle.add(count);
            }
        }
        Collections.sort(cycle);
        Collections.sort(noCycle);
        int n1 = cycle.size() - 1;
        int n2 = noCycle.size() - 1;
        long res = 0;
        while (n1 >= 0) {
            int val = cycle.get(n1);
            if (val > 2) {
                res += (n * (n - 1)) + (n * (n - 2));
                val--;
                n--;
            }
            while (val > 2) {
                res += (n * (n - 2));
                n--;
                val--;
            }
            res += (n * (n - 1));
            n -= 2;
            n1--;
        }
        while (n2 >= 0) {
            int val = noCycle.get(n2);
            int val1 = val;
            if (val == 2) {
                res += (n * (n - 1));
                n -= 2;
            }
            if (val > 2) {
                res += (n * (n - 1)) + (n * (n - 2));
                n--;
                val--;
            }
            while (val > 2) {
                res += (n * (n - 2));
                n--;
                val--;
            }
            if (val1 != 2)
                n -= 2;
            n2--;
        }

        return res;
    }
}