class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < responses.size();i++){
            List<String> l = responses.get(i);
            Set<String> set = new HashSet<>();
            for(int j = 0; j < l.size() ;j++){
              set.add(l.get(j));
            }
            for(String s:set){
                map.put(s,map.getOrDefault(s,0)+1);
                max = Math.max(max,map.get(s));
            }
        }
        String res="";
        for(String s:map.keySet()){
            int val = map.get(s);
            if(val == max){
                if(res == ""){
                    res = s;
                }
                else if(s.compareTo(res)<0){
                    res = s;
                }
            }
        }
        return res;
    }
}