class Solution {
    public int countPairs(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length-1; i >= 0; i--) {
            ArrayList<Integer> l = new ArrayList<>();
            int num = nums[i];
            while (nums[i] > 0) {
                l.add(nums[i] % 10);
                nums[i] /= 10;
            }
            if (l.size() == 1 && !set.contains(num)) {
                int ele = map.get(num);
                res += (ele * (ele - 1)) / 2;
                set.add(num);
            }
            else if(l.size() == 1){
                continue;
            } else {
                int pow = 1;
                for (int j = 0; j < l.size(); j++) {
                    int mul = pow;
                    for (int k = j + 1; k < l.size(); k++) {
                        mul *= 10;
                        int val = num;
                        val -= l.get(j) * pow;
                        val += l.get(k) * pow;
                        val += l.get(j) * mul;
                        val -= l.get(k) * mul;
                        if (map.containsKey(val) && num!=val)
                            res += map.get(val);
                    }
                    pow *= 10;
                }
                res += map.get(num)-1;
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        return res;
    }
}