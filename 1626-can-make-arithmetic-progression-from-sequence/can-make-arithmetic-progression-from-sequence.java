class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int val = arr[1]-arr[0];
        for(int i = 1; i < arr.length-1 ;i++){
            if(arr[i+1]-arr[i] != val){
                return false;
            }
        }
        return true;
    }
}