class Solution {
    public boolean traverse(String s,int i, int j,int count){
        if(count < 0){
            return false;
        }
        else if(i>=j){
            return true;
        }
        else{
            if(s.charAt(i) == s.charAt(j)){
                return traverse(s,i+1,j-1,count);
            }
            else{
                return traverse(s,i+1,j,count-1) || traverse(s,i,j-1,count-1);
            }
        }
    }
    public boolean validPalindrome(String s) {
       return traverse(s,0,s.length()-1,1);
    }
}