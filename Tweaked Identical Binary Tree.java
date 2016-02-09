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
     * @param a, b, the root of binary trees.
     * @return true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        if(a.val != b.val){
            return false;
        }
        return isTweakedIdentical(a.left, b.right) &&
        isTweakedIdentical(a.right, b.left) || //后边这种情况就是完全一样  前边情况就是拧个劲儿
        isTweakedIdentical(a.left, b.left) && 
        isTweakedIdentical(a.right, b.right);
         
    }
}