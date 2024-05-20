class Solution {
    public int matrixScore(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        for(int i=0;i<r;i++){
            if(grid[i][0]==0){
                for(int j=0;j<c;j++){
                    if(grid[i][j] == 0){
                        grid[i][j] = 1;
                    }
                    else{
                        grid[i][j] = 0;
                    }
                }
            }
        }
        int res=0;
        int val=1;
        for(int j=c-1;j>=0;j--){
            int count=0;
            for(int i=0;i<r;i++){
               if(grid[i][j] == 1){
                count++;
               }
            }
            count=Math.max(count,r-count);
            res+=(count*val);
            val*=2;
        }
        return res;
    }
}