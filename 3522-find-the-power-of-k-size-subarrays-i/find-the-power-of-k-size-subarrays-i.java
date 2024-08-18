class Solution {
    public int[] resultsArray(int[] arr, int k) {
        int n = arr.length;
        int val = 1, i = 1;
        int res[] = new int[n - k + 1];
        while (i < k) {
            if (arr[i] - 1 == arr[i - 1]) {
                val = val + 1;
            } else {
                val = 1;
            }
            i++;
        }
        if (val == k) {
            res[i - k] = arr[i - 1];
        } else {
            res[i - k] = -1;
        }
        while (i < n) {
            if (arr[i] - 1 == arr[i - 1]) {
                val = val + 1;
            } else {
                val = 1;
            }
            i++;
            if (val >= k) {
                res[i - k] = arr[i - 1];
            } else {
                res[i - k] = -1;
            }
        }
        return res;
    }
}