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
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        left = left == 0 ? Integer.MAX_VALUE : left;//让他是MAX 是因为要看right是多少 左边是null就不算他的depth了 就只看右边？？？？？？？？？？
        right = right == 0 ? Integer.MAX_VALUE : right;
        return Math.min(left, right) + 1;
    }
}