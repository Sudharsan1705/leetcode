class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            int arr[] = new int[32];
            int in = 0;
            while (num > 0) {
                arr[in++] = num % 2;
                num /= 2;
            }
            int val = 0;
            int k = 1;
            int index = 0;
            while (arr[index] == 1 && index <= in) {
                val += k;
                k *= 2;
                index++;
            }
            val /= 2;
            while (index <= in) {
                if (arr[index] == 1) {
                    val += k;
                }
                k *= 2;
                index++;
            }
            if (nums.get(i) != 2)
                res[i] = val;
            else
                res[i] = -1;
        }
        return res;
    }
}