class Solution {
    int res=0;
    int count=0;
    public void traverse(int grid[][],int i,int j,int r,int c){
        if(i<0 || j<0 || i == r || j == c){
            return;
        }
        else if(grid[i][j] == 0){
            return ;
        }
        else{
            count++;
            grid[i][j] = 0;
            traverse(grid,i+1,j,r,c);
            traverse(grid,i,j+1,r,c);
            traverse(grid,i-1,j,r,c);
            traverse(grid,i,j-1,r,c);  
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        res=0;
        int r=grid.length;
        int c=grid[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1){
                    count=0;
                    traverse(grid,i,j,r,c);
                    res=Math.max(res,count);
                }
            }
        }
        return res;
    }
}