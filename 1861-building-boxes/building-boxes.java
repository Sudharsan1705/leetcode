class Solution {
    public int minimumBoxes(int n) {
        if(n <= 3)
        return n;
        int floor = 3;
        int sum=3;
        int val=3;
        while(sum<=n){
            floor+=val;
            sum+=val+(val*(val-1))/2;
            val++;
        }
        val--;
        sum-=val+(val*(val-1))/2;
        floor-=val;
        int count=1;
        sum+=1;
        while(sum<n){
           sum+=count;
           floor++;
           count++;
        }
        return floor;
    }
}