/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()){
           int size = queue.size();
           Map<Integer,Integer> map = new HashMap<>();
           int arr[] = new int[size];
           int sort[] = new int[size];
           int in = 0;
           while(in < size){
              TreeNode n = queue.poll();
              arr[in] = n.val;
              sort[in] = n.val;
              map.put(n.val,in);
              if(n.left!=null){
                queue.offer(n.left);
              }
              if(n.right!=null){
                queue.offer(n.right);
              }
              in++;
           }
           Arrays.sort(sort);
           for(int i = 0; i < size;i++){
            if(!map.containsKey(sort[i]) || map.get(sort[i]) == i){
                map.remove(sort[i]);
                continue;
            }
            else{
                int pos1 = map.get(sort[i]);
                int pos2 = map.get(sort[pos1]);
                if(arr[pos2] == sort[pos1] && arr[pos1] == sort[pos2]){
                   res++;
                   map.remove(sort[pos1]);
                   map.remove(sort[pos2]);
                }
                else{
                    res++;
                    map.put(arr[i],map.get(sort[i]));
                    arr[map.get(sort[i])] = arr[i];
                    map.remove(sort[i]);
                }
            }
           }
        }
        return res;
    }
}