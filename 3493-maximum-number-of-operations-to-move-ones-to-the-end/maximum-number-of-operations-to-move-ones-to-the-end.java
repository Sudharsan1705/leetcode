class Solution {
    public int maxOperations(String s) {
        int res=0;
        int one=0;
        int in=0,len=s.length();
        while(in<len){
            int zero=0;
           while(in<len && s.charAt(in) == '1'){
            in++;
            one++;
           }
           while(in<len && s.charAt(in) == '0'){
            zero++;
            in++;
           }
           if(zero>0){
            res+=one;
           }
        }
        return res;
    }
}