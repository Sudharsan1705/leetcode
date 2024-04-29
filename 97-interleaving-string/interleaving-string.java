class Solution {
    boolean flag;
    public void traverse(int dp[][],char ch1[],char ch2[],char ch3[],int i,int j,int k,int n1,int n2,int n3){
         if(i<n1 && j<n2 && dp[i][j]!=0){
            return;
         }
         if(k == n3){
            if(i == n1 && j == n2)
            flag=true;
            return;
         }
         if(i<n1 && ch1[i] == ch3[k]){
            if(j<n2){
            dp[i][j]=1;
            }
            if(!flag)
            traverse(dp,ch1,ch2,ch3,i+1,j,k+1,n1,n2,n3);
         }
         if(j<n2 && ch2[j] == ch3[k]){
            if(i<n1){
            dp[i][j]=1;
            }
            if(!flag)
            traverse(dp,ch1,ch2,ch3,i,j+1,k+1,n1,n2,n3);
         }
    }
    public boolean isInterleave(String s1, String s2, String s3) {
       int n1=s1.length();
       int n2=s2.length();
       int n3=s3.length();
       int dp[][]=new int[n1][n2];
       flag=false;
       traverse(dp,s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),0,0,0,n1,n2,n3);
       return flag; 
    }
}