class Solution {
    public String longestWord(String[] words) {
      Arrays.sort(words,(a,b)->{
          if(a.length() == b.length())
          return b.compareTo(a);
          return a.length()-b.length();
      });
      Set<String> set = new HashSet<>();
      set.add("");
      for(int i=0;i<words.length;i++){
          set.add(words[i]);
      }
      for(int i=words.length-1;i>=0;i--){
          String str=words[i];
          int l=str.length()-1;
          while(l>0){
              if(!set.contains(str.substring(0,l))){
                  break;
              }
              l--;
          }
          if(l == 0)
          return str;
      }
      return "";
    }
}