class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<Long> set = new HashSet<>();
        int n=s.length();
        for(int i=0;i<=n-k;i++){
            set.add(Long.parseLong(s.substring(i,i+k),2));
        }
        int len=(int)Math.pow(2,k);
       // System.out.println(len);
        for(int i=0;i<len;i++){
            if(!set.contains((long)i)){
                return false;
            }
        }
        
        return true;
    }
}