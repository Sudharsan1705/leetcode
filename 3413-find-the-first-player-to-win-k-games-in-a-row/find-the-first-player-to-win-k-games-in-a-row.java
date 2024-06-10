class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int n=skills.length;
        int count=0;
        int in=0;
        int pre=skills[0];
        for(int i=1;i<n;i++){
           if(skills[i]<pre){
            count++;
           }
           else{
            in=i;
            count=1;
            pre=skills[i];
           }
           if(count == k){
            return in;
           }
        }
        return in;
    }
}