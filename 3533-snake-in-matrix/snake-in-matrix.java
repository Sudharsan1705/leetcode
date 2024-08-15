class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x=0,y=0;
        for(String s:commands){
            if(s.equals("RIGHT")){
                y++;
            }
            if(s.equals("DOWN")){
                x++;
            }
            if(s.equals("LEFT")){
                y--;
            }
            if(s.equals("UP")){
                x--;
            }
        }
        return n*x+y;
    }
}