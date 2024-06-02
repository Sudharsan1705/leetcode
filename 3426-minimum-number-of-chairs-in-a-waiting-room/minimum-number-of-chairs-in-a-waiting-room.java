class Solution {
    public int minimumChairs(String s) {
        char ch[]=s.toCharArray();
        for(int i=1;i<=50;i++){
            int val=i;
            for(int j=0;j<ch.length;j++){
                if(val<0){
                    break;
                }
                else if(ch[j] == 'E'){
                    val--;
                }
                else{
                    val++;
                }
            }
            if(val>=0){
                return i;
            }
        }
        return 0;
    }
}