class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int ad) {
        int res = 0;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] > rocks[i]) {
                l.add(capacity[i] - rocks[i]);
            } else {
                res++;
            }
        }
        Collections.sort(l);
        for (int i = 0; i < l.size(); i++) {
            if (ad >= l.get(i)) {
                ad -= l.get(i);
                res++;
            }
        }
        return res;
    }
}