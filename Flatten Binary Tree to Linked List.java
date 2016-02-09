public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        flatten(root, null);
    }
    private TreeNode flatten(TreeNode root, TreeNode prevTail) {// preTail 为root的父节点
        if (prevTail != null) {
            prevTail.left = null;
            prevTail.right = root;
        }
        prevTail = root;
        TreeNode right = root.right;// 没有这个就会出错！！！！！！
        if (root.left != null) {
            prevTail = flatten(root.left, prevTail);
        }
        if (right != null) {
            prevTail = flatten(right, prevTail);
        }
        return prevTail;
    }
}


or



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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if(root == null){
            return;
        }
        help(root, null);
    }
    
    public TreeNode help(TreeNode root, TreeNode preTail){
        if(preTail != null){
            preTail.left = null;
            preTail.right = root;
        }
        preTail = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left != null){
            preTail = help(left, preTail);
        }
        if(right != null){
            preTail = help(right, preTail);
        }
        return preTail;
    }
}


