class Solution {
    public String frequencySort(String s) {
        String str="";
        int a[]=new int[123];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)]++;
        }
        int b[]=new int[s.length()];
        int c[]=new int[s.length()];
        int x=0;
        for(int i=47;i<123;i++){
            if(a[i]!=0){
               b[x]=a[i];
               c[x]=i;
               x++;
            }
        }
        int t=0,t1=0;
        for(int i=0;i<x;i++){
            for(int j=i+1;j<x;j++){
                if(b[i]<b[j]){
                   t=b[i];
                   t1=c[i];
                   b[i]=b[j];
                   c[i]=c[j];
                   b[j]=t;
                   c[j]=t1;
                }
            }
        }
        // for(int i=0;i<x;i++){
        //     System.out.print(b[i]+" ");
        // }
        for(int i=0;i<x;i++){
            for(int j=0;j<b[i];j++){
             str+=(char)c[i];
            }
        }
        return str;
    }
}