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
    List<Integer> list;
    public int traverse(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = traverse(root.left);
        int r = traverse(root.right);
        if(l == r && l != -1 && r != -1){
            int val1 = (int)Math.pow(2,l)-1;
            val1+=val1;
            list.add(val1+1);
        }
        else{
            return -1;
        }
        return l+1;
    }
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        list = new ArrayList<>();
        traverse(root);
        if(list.size()<k){
            return -1;
        }
        Collections.sort(list,Collections.reverseOrder());
        return list.get(k-1);
    }
}