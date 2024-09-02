class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long tot = 0;
        for (int i = 0; i < chalk.length; i++) {
            tot += chalk[i];
        }
        if(k >= tot)
        k = k % (int)tot;
        int in = 0;
        while (k > 0) {
            if (k < chalk[in]) {
                return in;
            } else {
                k -= chalk[in];
                in++;
            }
        }
        return in;
    }
}