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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (null == root || A == root ||B == root) return root;
        
        // a b 可都在一边或者分别两边 若两边 那肯定是root
        TreeNode l = lowestCommonAncestor(root.left, A, B);
        TreeNode r = lowestCommonAncestor(root.right, A, B);
        if (l != null && r != null){
            return root;
        }
        if (l != null){
            return l; 
        }
        if (r !=null){
            return r;
        }
        return null;
    }
}
