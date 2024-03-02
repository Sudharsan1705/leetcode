class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
      int r=mat.length;  
      int c=mat[0].length;
      int sum[][]=new int[r+1][c+1];
      int res[][]=new int[r][c];
      for(int i=0;i<r;i++){
          int tot=0;
          for(int j=0;j<c;j++){
             tot+=mat[i][j];
             sum[i+1][j+1]=tot;
          }
      }
      for(int i=0;i<c;i++){
          int tot=0;
          for(int j=0;j<r;j++){
           tot+=sum[j+1][i+1];
           sum[j+1][i+1]=tot;
          }
      }
      for(int i=0;i<r;i++){
          for(int j=0;j<c;j++){
             int m=i+k;
             int n=j+k;
             if(m>=r){
                 m=r-1;
             }
             if(n>=c){
                 n=c-1;
             }
             int val=sum[m+1][n+1];
             int x=i-k;
             int y=j-k;
             if(x<0){
                 x=0;
             }
             if(y<0){
                y=0;
             }
             res[i][j]=val-sum[m+1][y]-sum[x][n+1]+sum[x][y];
          }
      }
    return res;
    }
}