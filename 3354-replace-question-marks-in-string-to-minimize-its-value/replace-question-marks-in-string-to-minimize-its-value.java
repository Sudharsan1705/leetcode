class Solution {
    public String minimizeStringValue(String s) {
        StringBuffer sb = new StringBuffer();
        Map<Character, Integer> map = new HashMap<>();
        char ch[] = s.toCharArray();
        int n = ch.length;
        for (char c = 'a'; c <= 'z'; c++) {
             map.put(c,0);
        }
        int in=0;
        for(int i=0;i<n;i++){
            if(ch[i]!='?')
            map.put(ch[i],map.getOrDefault(ch[i],0)+1);
            else
            in++;
        }
        char sort[]=new char[in];
        int j=0;
        for (int i = 0; i < n; i++) {
            if (ch[i] != '?') {
                continue;
            } else {
                int min = Integer.MAX_VALUE;
                for (char c : map.keySet()) {
                    min = Math.min(map.get(c), min);
                }
                for (char c = 'a'; c <= 'z'; c++) {
                    if (map.get(c) == min) {
                        sort[j++]=c;
                        map.put(c, map.getOrDefault(c, 0) + 1);
                        break;
                    }
                }
            }
        }
        Arrays.sort(sort);
        j=0;
        for(int i=0;i<n;i++){
            if(ch[i]=='?'){
                sb.append(sort[j++]);
            }
            else{
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}