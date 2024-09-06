class Solution {
    public int maxNumberOfFamilies(int n, int[][] arr) {
        long res = n * 2;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] > 1 && arr[i][1] < 10) {
                if (!map.containsKey(arr[i][0])) {
                    map.put(arr[i][0], new HashSet<>());
                }
                int val = arr[i][1];
                if (val < 4) {
                    if (!map.get(arr[i][0]).contains(1)) {
                        map.get(arr[i][0]).add(1);
                    }
                } else if (val > 7) {
                    if (!map.get(arr[i][0]).contains(3)) {
                        map.get(arr[i][0]).add(3);
                    }
                } else {
                    if (val < 6) {
                        if (!map.get(arr[i][0]).contains(1)) {
                            map.get(arr[i][0]).add(1);
                        }
                        if (!map.get(arr[i][0]).contains(2)) {
                            map.get(arr[i][0]).add(2);
                        }
                    } else {
                        if (!map.get(arr[i][0]).contains(3)) {
                            map.get(arr[i][0]).add(3);
                        }
                        if (!map.get(arr[i][0]).contains(2)) {
                            map.get(arr[i][0]).add(2);
                        }
                    }
                }
            }
        }
        for(int i : map.keySet()){
            Set<Integer> set = map.get(i);
            if(set.size() == 3){
                res -= 2;
            }
            else{
                res -= 1;
            }
        }
        return (int) res;
    }
}