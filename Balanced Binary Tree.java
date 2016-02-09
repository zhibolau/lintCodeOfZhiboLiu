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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return getHeight(root) != -1 ? true : false;
    }
    public int getHeight(TreeNode root){
        if (null == root){
            return 0;
        }
        int l = getHeight(root.left), r = getHeight(root.right);
        if (l == -1) return -1; //？？？？？？？？？？？？ 啥意思 为啥设成-1？？
        if (r == -1) return -1;
        return Math.abs(l - r) > 1 ? -1 : Math.max(l, r) + 1;
    }
}
