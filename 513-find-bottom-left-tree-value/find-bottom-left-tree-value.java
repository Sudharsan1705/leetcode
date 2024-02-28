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
    public int findBottomLeftValue(TreeNode root) {
        int res=-1;
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            if(size>0)
            res=q.getFirst().val;
            while(size>0){
             TreeNode t=q.getFirst();
             if(t.left!=null)
                q.add(t.left);
             if(t.right!=null)
                q.add(t.right);
            
                q.removeFirst();
                size--;
            }
            System.out.println(); 
        }
        return res;
    }
}