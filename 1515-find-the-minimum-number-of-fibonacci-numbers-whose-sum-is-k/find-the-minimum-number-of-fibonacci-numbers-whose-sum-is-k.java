class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        int a = 1;
        int b = 1;
        int c = a + b;
        list.add(1);
        list.add(1);
        while (c <= k) {
            list.add(c);
            a = b;
            b = c;
            c = a + b;
        }
        int in = list.size() - 1;
        int res = 0;
        while (k > 0) {
            if (k - list.get(in) >= 0) {
                k -= list.get(in);
                res++;
            }
            in--;
        }
        return res;
    }
}