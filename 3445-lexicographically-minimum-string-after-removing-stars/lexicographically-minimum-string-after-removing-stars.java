class Solution {
    public String clearStars(String s) {
        char ch[]=s.toCharArray();
        int len=s.length();
        int hash[]=new int[26];
        Set<Integer> set = new HashSet<>();
        char temp='*';
        for(int i=0;i<len;i++){
            if(ch[i]!='*'){
                hash[ch[i]-'a']++;
            }
            else{
                for(int j=0;j<26;j++){
                    if(hash[j]>0){
                        hash[j]--;
                        set.add(i);
                        ch[i]=(char)(j+'a');
                        break;
                    }
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=len-1;i>=0;i--){
           if(set.contains(i)){
               map.put(ch[i],map.getOrDefault(ch[i],0)+1);
           }
           else{
            if(map.containsKey(ch[i])){
                map.put(ch[i],map.get(ch[i])-1);
                if(map.get(ch[i]) == 0){
                    map.remove(ch[i]);
                }
            }
            else
            sb.append(ch[i]);
           }
        }
        return sb.reverse().toString();
    }
}