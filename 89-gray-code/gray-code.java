class Solution {
    Set<Integer> set;
    List<Integer> list;
    public void traverse(int arr[],int limit){
        int num=0;
        int val=1;
        for(int i=0;i<31;i++){
            if(arr[i] == 1){
                num+=val;
            }
            val*=2;
        }
        if(!set.contains(num) && num < limit){
            set.add(num);
            list.add(num);
            for(int i=0;i<31;i++){
                int temp=arr[i];
                arr[i] = arr[i] == 0 ?1:0;
                traverse(arr,limit);
                arr[i]=temp;
            }
        }
    }
    public List<Integer> grayCode(int n) {
        set = new HashSet<>();
        list = new ArrayList<>();
        int arr[]=new int[32];
        int in=0,temp=(int)Math.pow(2,n-1);
        while(temp>0){
         arr[in++]=temp%2;
         temp/=2;
        }
        list.add(0);
        set.add(0);
        traverse(arr,(int)Math.pow(2,n));
        return list;
    }
}