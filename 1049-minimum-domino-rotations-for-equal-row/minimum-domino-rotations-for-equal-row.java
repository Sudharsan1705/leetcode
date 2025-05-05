class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = tops.length+2;
        int t[] = new int[7];
        int b[] = new int[7];
        for(int i =0 ; i < tops.length;i++){
            if(tops[i] == bottoms[i]){
                t[tops[i]]++;
            }
            else{
                t[tops[i]]++;
                b[bottoms[i]]++;
            }
        }
        for(int i = 1; i < 7;i++){
            if(t[i]+b[i] == tops.length)
            res = Math.min(res,b[i]);
        }
        int t1[] = new int[7];
        int b1[] = new int[7];
        for(int i =0 ; i < tops.length;i++){
            if(tops[i] == bottoms[i]){
                b1[tops[i]]++;
            }
            else{
                t1[tops[i]]++;
                b1[bottoms[i]]++;
            }
        }
        for(int i = 1; i < 7;i++){
            if(t1[i]+b1[i] == tops.length)
            res = Math.min(res,t1[i]);
        }
        return res!=tops.length+2?res:-1;
    }
}