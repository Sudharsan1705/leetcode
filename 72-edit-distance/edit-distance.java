class Solution {
    public int find(int dp[][],char ch1[],char ch2[],int i,int j,int n1,int n2){
        int res=1000;
        if(j == n2){
            return n1 - i;
        }
        else if(i == n1){
            return n2 - j;
        }
        else if(dp[i][j]!=0){
            return dp[i][j];
        }
        else{
            if(ch1[i] == ch2[j]){
               res=find(dp,ch1,ch2,i+1,j+1,n1,n2);
            }
            // a bbb
            else{
            //delete
            // if(n1-i>n2-j){
              res=Math.min(res,1+find(dp,ch1,ch2,i+1,j,n1,n2));
            // }
            //insert
            res=Math.min(res,1+find(dp,ch1,ch2,i,j+1,n1,n2));
            //replace
            res=Math.min(res,1+find(dp,ch1,ch2,i+1,j+1,n1,n2));
            }
        }
        return dp[i][j]=res;
    }
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()][word2.length()];
        int ans = find(dp,word1.toCharArray(),word2.toCharArray(),0,0,word1.length(),word2.length());
        // for(int i[] : dp){
        //     System.out.println(Arrays.toString(i));
        // }
        return ans;
    }
}
