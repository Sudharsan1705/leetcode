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
    List<Integer> l;
    Map<Integer,Integer> map;
    public void traverse(TreeNode root){
        if(root!=null){
            traverse(root.left);
            l.add(root.val);
            traverse(root.right);
        }
    }
    public void change(TreeNode root){
        if(root!=null){
            root.val=map.get(root.val);
            change(root.left);
            change(root.right);
        }
    }
    public TreeNode convertBST(TreeNode root) {
        l=new ArrayList<>();
        map= new HashMap<>();
        traverse(root);
      //  Collections.sort(l);
        int size=l.size();
        int sum=0;
        for(int i=size-1;i>=0;i--){
            sum+=l.get(i);
            map.put(l.get(i),sum);
        }
        change(root);
        return root;
    }
}