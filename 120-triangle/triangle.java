class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        res.add(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> l = triangle.get(i);
            int n = l.size();
            res.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    res.get(i).add(res.get(i - 1).get(0) + l.get(j));
                } else if (j == n - 1) {
                    res.get(i).add(res.get(i - 1).get(j - 1) + l.get(j));
                } else {
                    int min = res.get(i - 1).get(j - 1) + l.get(j);
                    min = Math.min(min, res.get(i - 1).get(j) + l.get(j));
                    res.get(i).add(min);
                }
            }
        }
        List<Integer> list = res.get(res.size() - 1);
        for (int i : list) {
            ans = Math.min(ans, i);
        }
        return ans;
    }
}