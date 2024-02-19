class Solution {
    public int maximumScore(int a, int b, int c) {
    int res=0;
     int arr[]=new int[3];
     arr[0]=a;
     arr[1]=b;
     arr[2]=c;
     Arrays.sort(arr);
     res+=arr[1]-arr[0];
     arr[1]=arr[0];
     arr[2]=arr[2]-res;
     if(arr[0]+arr[1]<=arr[2]){
         return res+(2*arr[0]);
     }
     int sum=((arr[0]+arr[1])-arr[2])/2;
     res+=sum;
     arr[0]-=sum;
     arr[1]-=sum;
     res+=Math.min(arr[0]+arr[1],arr[2]);
     return res;
    }
}