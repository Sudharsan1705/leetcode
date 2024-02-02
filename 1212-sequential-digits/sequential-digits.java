class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> l = new ArrayList<>();
        for(int i=1;i<=9;i++){
            StringBuffer sb = new StringBuffer();
            sb.append(i);
            int val=i;
            int num=i+1;
            while(val<=high){
                if(val>=low){
                    l.add(val);
                }
                sb.append(num);
                num++;
                if(num>10)
                break;
                val=Integer.parseInt(sb.toString());
            }
        }
        Collections.sort(l);
        return l;
    }
}