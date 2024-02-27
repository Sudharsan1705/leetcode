class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length;
        int arr[] = new int[n];
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = queries[i];
        }
        Arrays.sort(arr);
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < items.length; i++) {
            if (!map.containsKey(items[i][0])) {
                map.put(items[i][0], items[i][1]);
            } else {
                map.put(items[i][0], Math.max(map.get(items[i][0]), items[i][1]));
            }
        }
        int max = 0;
        Map<Integer, Integer> m = new HashMap<>();
        int in = 0;
        for (int i : map.keySet()) {
            while (in < n && arr[in] < i) {
                m.put(arr[in], max);
                in++;
            }
            max = Math.max(map.get(i),max);
            if(in<n && arr[in] == i){
                m.put(arr[in],max);
                in++;
            }
        }
        while (in < n) {
            m.put(arr[in], max);
            in++;
        }
      //  System.out.println(m);
        for(int i=0;i<n;i++){
            res[i]=m.get(queries[i]);
        }
        return res;

    }
}