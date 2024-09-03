class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;
            while (val > 0) {
                sum += val % 10;
                val /= 10;
            }
        }
        k -= 1;
        while (k > 0) {
            int res = 0;
            while (sum > 0) {
                res += sum % 10;
                sum /= 10;
            }
            sum = res;
            k--;
        }
        return sum;
    }
}