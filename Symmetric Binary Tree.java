/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if(root == null){
            return true;
        }
        return help(root.left, root.right);
    }
    public boolean help(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null){
            return true;
        }
        if(n1 == null || n2 == null){
            return false;
        }
        if(n1.val != n2.val){
            return false;
        }
        return help(n1.left, n2.right) && help(n1.right, n2.left);//看两个node左右是否一样 对称 都得一样 并且！！！！
    }
}