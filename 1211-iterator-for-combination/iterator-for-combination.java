class CombinationIterator {
    List<String> l;
    int in=0;
    int size=0;
    public CombinationIterator(String characters, int combinationLength) {
        l=new ArrayList<>();
        comb(characters.toCharArray(),0,combinationLength,0,new StringBuffer());
        size=l.size();
      //  System.out.println(l);
    }
    public void comb(char ch[],int start,int end,int in,StringBuffer sb){
        if(start == end){
            l.add(new String(sb.toString()));
        }
        else{
            for(int i=in;i<ch.length;i++){
                sb.append(ch[i]);
                comb(ch,start+1,end,i+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public String next() {
        in++;
        return l.get(in-1);
    }
    
    public boolean hasNext() {
        if(in<size){
            return true;
        }
        return false;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */