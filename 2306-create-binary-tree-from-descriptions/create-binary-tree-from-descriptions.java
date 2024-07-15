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
    public TreeNode createBinaryTree(int[][] arr) {
      Set<Integer> set = new HashSet<>();
      Map<Integer,TreeNode> map =new HashMap<>();
      int n=arr.length;
      for(int i=0;i<n;i++){
          TreeNode t = null;
          TreeNode p = null;
          if(!map.containsKey(arr[i][1])){
               t = new TreeNode(arr[i][1]);
               map.put(arr[i][1],t);
          }
          else{
              t=map.get(arr[i][1]);
          }
          if(!map.containsKey(arr[i][0])){
               p=new TreeNode(arr[i][0]);
               map.put(arr[i][0],p);
          }
          else{
              p=map.get(arr[i][0]);
          }
          if(arr[i][2] == 1)
          p.left = t;
          else
          p.right = t;
          set.add(arr[i][1]);
        }
      for(int i:map.keySet()){
          if(!set.contains(i)){
              return map.get(i);
          }
      }
      return null;
    }
}