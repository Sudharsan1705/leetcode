class Solution {
    int val;
    public void dfs(int grid[][],int i,int j,int r,int c,boolean v[][]){
        if(i<0 || i==r || j<0 || j == c){
            return;
        }
        else if(v[i][j] == true || grid[i][j] == 0){
            return;
        }
        else{
            v[i][j] = true;
            val+=grid[i][j];
            dfs(grid,i+1,j,r,c,v);
            dfs(grid,i,j+1,r,c,v);
            dfs(grid,i-1,j,r,c,v);
            dfs(grid,i,j-1,r,c,v);
        }
    }
    public int findMaxFish(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        boolean v[][]=new boolean[r][c];
        int max=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]>0 && !v[i][j]){
                    val=0;
                    dfs(grid,i,j,r,c,v);
                    max=Math.max(max,val);
                }
            }
        }
        return max;
    }
}