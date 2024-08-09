class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int res=0;
        int r=grid.length;
        int c=grid[0].length;
        for(int i=0;i<r-2;i++){
            for(int j=0;j<c-2;j++){
                Set<Integer> set = new HashSet<>();
                Set<Integer> num = new HashSet<>();
                int r1=0,r2=0,r3=0,c1=0,c2=0,c3=0,d1=0,d2=0;
                set.add(grid[i][j]);
                r1+=grid[i][j];
                c1+=grid[i][j];
                d1+=grid[i][j];
                set.add(grid[i][j+1]);
                r1+=grid[i][j+1];
                c2+=grid[i][j+1];
                set.add(grid[i][j+2]);
                r1+=grid[i][j+2];
                c3+=grid[i][j+2];
                d2+=grid[i][j+2];
                set.add(grid[i+1][j]);
                r2+=grid[i+1][j];
                c1+=grid[i+1][j];
                set.add(grid[i+1][j+1]);
                r2+=grid[i+1][j+1];
                c2+=grid[i+1][j+1];
                d1+=grid[i+1][j+1];
                d2+=grid[i+1][j+1];
                set.add(grid[i+1][j+2]);
                r2+=grid[i+1][j+2];
                c3+=grid[i+1][j+2];
                set.add(grid[i+2][j]);
                r3+=grid[i+2][j];
                c1+=grid[i+2][j];
                d2+=grid[i+2][j];
                set.add(grid[i+2][j+1]);
                r3+=grid[i+2][j+1];
                c2+=grid[i+2][j+1];
                set.add(grid[i+2][j+2]);
                r3+=grid[i+2][j+2];
                c3+=grid[i+2][j+2];
                d1+=grid[i+2][j+2];
                boolean flag=false;
                for(int k=10;k<=15;k++){
                    if(set.contains(k)){
                        flag=true;
                    }
                }
                num.add(r1);
                num.add(r2);
                num.add(r3);
                num.add(d1);
                num.add(d2);
                num.add(c1);
                num.add(c2);
                num.add(c3);
                if(flag || set.contains(0) || set.size()!=9 || num.size()>1){
                    continue;
                }
                else{
                    res++;
                }
            }
        }
        return res;
    }
}