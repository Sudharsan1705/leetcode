class Solution {
    String s;
    int num;
    public void backtrack(char ch[],int n,int pre,StringBuffer sb){
        if(n == 0){
          //  System.out.println(sb);
            num--;
            if(num == 0){
                s=new String(sb.toString());
            }
        }
        else{
            for(int i=0;i<3;i++){
                if(pre!=i && s==null){
                    sb.append(ch[i]);
                    backtrack(ch,n-1,i,sb);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
    public String getHappyString(int n, int k) {
        char ch[]={'a','b','c'};
        num=k;
        backtrack(ch,n,-1,new StringBuffer());
        if(s == null)
        s="";
        return s;
    }
}