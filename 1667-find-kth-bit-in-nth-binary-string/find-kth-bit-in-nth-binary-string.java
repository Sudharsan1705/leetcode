class Solution {
    public StringBuffer invert(StringBuffer sb){
        StringBuffer s = new StringBuffer();
        for(int i = 0 ; i < sb.length() ;i++){
            if(sb.charAt(i) == '0'){
               s.append('1');
            }
            else{
                s.append('0');
            }
        }
        return s.reverse();
    }
    public char findKthBit(int n, int k) {
        StringBuffer sb = new StringBuffer();
        sb.append('0');
        n--;
        while(n-- > 0){
           StringBuffer s = invert(sb);
           sb.append('1');
           sb.append(s);
        }
        return sb.charAt(k-1);
    }
}