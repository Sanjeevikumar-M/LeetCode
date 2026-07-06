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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return isVisited(root,k,set);
    }
    private static boolean isVisited(TreeNode node,int k,HashSet<Integer> set){
        if(node==null){
            return false;
        }
        if(set.contains(k-node.val)){
            return true;
        }
        else{
            set.add(node.val);
        }
        return isVisited(node.left,k,set) || isVisited(node.right,k,set);
    }
}