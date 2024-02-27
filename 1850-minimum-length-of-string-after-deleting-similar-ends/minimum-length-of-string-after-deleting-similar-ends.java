class Solution {
    public int minimumLength(String s) {
        char ch[]=s.toCharArray();
        int n=ch.length;
        int l=0;
        int r=n-1;
        while(l<r){
            if(ch[l] == ch[r]){
                char c=ch[l];
                while(l<=r){
                    if(c == ch[l]){
                      l++;
                    }
                    else{
                        break;
                    }
                }
                while(r>=l){
                    if(c == ch[r]){
                      r--;
                    }
                    else{
                        break;
                    }
                }
            }
            else{
                break;
            }
        }
        if(l==r){
            return 1;
        }
        return r-l+1;
    }
}