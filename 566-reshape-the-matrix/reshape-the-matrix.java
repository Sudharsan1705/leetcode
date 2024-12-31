class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat[0].length*mat.length != r*c)
        return mat;
        int res[][] = new int[r][c];
        int m = 0, n = 0;
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[i].length ; j++){
                if(n == c){
                    m++;
                    n = 0;
                }
                res[m][n] = mat[i][j];
                n++;
            }
        }
        return res;
    }
}