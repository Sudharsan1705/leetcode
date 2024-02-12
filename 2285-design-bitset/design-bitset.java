class Bitset {
    int arr[]=null;
    int flip = 1;
    int one = 0;
    int s;
    public Bitset(int size) {
        arr=new int[size];
        s=size;
    }
    
    public void fix(int idx) {
        if(flip == 1){
        if(arr[idx]!=1)
        one++;
        arr[idx]=1;
        }
        else{
            if(arr[idx]!=0)
            one++;
            arr[idx]=0;
        }
    }
    
    public void unfix(int idx) {
        if(flip == 1){
        if(arr[idx] == 1)
        one--;
        arr[idx]=0;
        }
        else 
        {
            if(arr[idx] == 0){
            one--;
            arr[idx]=1;
            }
        }
    }
    
    public void flip() {
       if(flip == 1){
           flip = -1;
           one = s-one;
       }
       else{
           flip = 1;
           one=s-one;
       }
    }
    
    public boolean all() {
        if(one == s){
          return true;
        }
        return false;
    }
    
    public boolean one() {
        if(one>0)
        return true;
        return false;
    }
    
    public int count() {
        return one;
    }
    
    public String toString() {
        if(flip == 1){
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<s;i++){
                sb.append(arr[i]);
            }
            return sb.toString();
        }
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<s;i++){
                if(arr[i] == 0)
                sb.append(1);
                else
                sb.append(0);
            }
            return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */