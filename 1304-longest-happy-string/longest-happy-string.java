class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuffer sb = new StringBuffer();
        int arr[][] = new int[3][2];
        arr[0][0]=97;
        arr[0][1]=a;
        arr[1][0]=98;
        arr[1][1]=b;
        arr[2][0]=99;
        arr[2][1]=c;
        Arrays.sort(arr,(at,bt)->bt[1]-at[1]);
        int pre=0;
        while(true){
            // for(int i=0;i<3;i++)
            //  System.out.println(arr[i][0]+" "+arr[i][1]);
            int max=0;
            for(int i=0;i<3;i++){
                if(pre!=arr[i][0]){
                    arr[i][1]-=1;
                    sb.append((char)arr[i][0]);
                    if(arr[i][1]!=0 && max<=arr[i][1]){
                      arr[i][1]-=1;
                      sb.append((char)arr[i][0]);
                    }
                    pre=arr[i][0];
                    break;
                }
                max=Math.max(arr[i][1],max);
            }
              Arrays.sort(arr,(at,bt)->bt[1]-at[1]);
            if(arr[1][1] == 0 ){
                if(pre!=arr[0][0]){
                sb.append((char)arr[0][0]);
                arr[0][1]-=1;
                if(arr[0][1]>0){
                sb.append((char)arr[0][0]);
                }}
                break;
            }
        }
        return sb.toString();
    }
}