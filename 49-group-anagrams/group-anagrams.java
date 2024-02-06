class Solution {
    public List<List<String>> groupAnagrams(String[] s) {
        List<List<String>> l=new ArrayList<List<String>>();
         String s1[]=new String[s.length];
         for(int i=0;i<s.length;i++){
             char c[]=s[i].toCharArray();
             Arrays.sort(c);
             s1[i]=new String(c);
         }
         int k=0;
         for(int i=0;i<s1.length;i++){
             List<String> a=new ArrayList<String>();
            k=0;
             if(!s1[i].equals("\0")){
                 a.add(s[i]);
                 k++;
             for(int j=0;j<s1.length;j++){
                 if(i!=j&&(!s1[j].equals("\0"))){
                  if(s1[i].equals(s1[j])){
                      a.add(s[j]);
                      s1[j]="\0";
                  }
                 }
             }
             }
            if(k!=0)
             l.add(a);
         }
        return l;
    }
}