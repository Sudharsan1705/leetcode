class Solution {
    public long maxEnergyBoost(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long arr1[] = new long[n];
        long arr2[] = new long[n];
        arr1[0] = nums1[0];
        arr2[0] = nums2[0];
        arr1[1] = nums1[1] + nums1[0];
        arr2[1] = nums2[1] + nums2[0];
        for (int i = 2; i < n; i++) {
            long val1 = arr1[i - 1] + nums1[i];
            long val2 = arr2[i - 2] + nums1[i];
            arr1[i] = Math.max(val1, val2);
            val1 = arr2[i - 1] + nums2[i];
            val2 = arr1[i - 2] + nums2[i];
            arr2[i] = Math.max(val1, val2);
        }
        return Math.max(arr1[n - 1], arr2[n - 1]);
    }
}