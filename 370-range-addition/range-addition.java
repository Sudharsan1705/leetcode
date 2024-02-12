class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int arr[]=new int[length];
        int val=0;
        int start[][] = new int[length][1];
        int end[][] = new int[length][1];
        int len=updates.length;
        for(int i=0;i<len;i++){
            start[updates[i][0]][0]+=updates[i][2];
            end[updates[i][1]][0]+=updates[i][2];
            
        }
        for(int i=0;i<length;i++){
            val+=start[i][0];
            arr[i]=val;
            val-=end[i][0];
        }
        return arr;
    }
}