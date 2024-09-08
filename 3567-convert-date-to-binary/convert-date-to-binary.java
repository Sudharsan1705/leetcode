class Solution {
    public String convertDateToBinary(String date) {
       StringBuffer sb = new StringBuffer();
       String str[] = date.split("-");
       for(int i = 0;i < 3 ;i++){
         sb.append(Integer.toString(Integer.parseInt(str[i]),2));
         if(i != 2){
            sb.append('-');
         }
       }
       return sb.toString(); 
    }
}