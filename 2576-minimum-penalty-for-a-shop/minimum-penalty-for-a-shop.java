class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int pre[]=new int[n];
        char ch[]=customers.toCharArray();
        int count=0;
        for(int i=n-1;i>=0;i--){
           pre[i]=count;
           if(ch[i] == 'Y'){
            count++;
           }
        }
        int min=count;
        count=0;
        for(int i=0;i<n;i++){
           if(ch[i] == 'N'){
            count++;
           }
           pre[i]+=count;
        }
        //System.out.println(Arrays.toString(pre));
        int res=0;
        for(int i=0;i<n;i++){
            if(min>pre[i]){
                min=pre[i];
                res=i+1;
            }
        }
        return res;
    }
}