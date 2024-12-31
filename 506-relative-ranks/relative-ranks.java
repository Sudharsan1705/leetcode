class Solution {
    public String[] findRelativeRanks(int[] score) {
        int temp[] = new int[score.length];
        for(int i = 0 ; i < score.length ; i++){
            temp[i] = score[i];
        }
        Arrays.sort(temp);
        int val = 1;
        Map<Integer,String> map = new HashMap<>();
        for(int i = temp.length-1 ; i >= 0 ; i--){
            if(val == 1)
            map.put(temp[i],"Gold Medal");
            else if(val == 2)
            map.put(temp[i],"Silver Medal");
            else if(val == 3)
            map.put(temp[i],"Bronze Medal");
            else
            map.put(temp[i],Integer.toString(val));
            val++;
        }
        String res[] = new String[score.length];
        for(int i = 0 ; i < score.length ; i++){
            res[i] = map.get(score[i]);
        }
        return res;
    }
}