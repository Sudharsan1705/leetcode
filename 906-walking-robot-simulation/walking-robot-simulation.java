class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            int val = obstacles[i][0];
            if (!map.containsKey(val)) {
                map.put(val, new HashSet<>());
            }
            map.get(val).add(obstacles[i][1]);
        }
        int res = 0 , x = 0 , y = 0;
        int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0;
        for (int i = 0; i < commands.length; i++) {
            if(commands[i] == -1){
                index += 1;
                if(index>3){
                    index = 0;
                }
            }
            else if(commands[i] == -2){
                index -= 1;
                if(index < 0){
                    index = 3;
                }
            }
            else{
                int val1 = dir[index][0];
                int val2 = dir[index][1];
               for(int j = 0;j < commands[i]; j++){
                  if(map.containsKey(x+val1) && map.get(x+val1).contains(y+val2)){
                    break;
                  }
                  x+=val1;
                  y+=val2;
               }
               res = Math.max((x*x)+(y*y),res);
            }
        }
        return res;
    }
}