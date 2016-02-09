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
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null){
            return node;
        }
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null){
            prev = cur;
            if(node.val > cur.val){
                cur = cur.right;
            }
            else{//此处必有else 否则出去if之后 cur值就改变了！！！！！！！！！！！！！！
                cur = cur.left;
            }
            
        }
        if(prev != null){
            if(node.val > prev.val){
                prev.right = node;
            }
            else{
                prev.left = node;
            }
            
        }
        return root;
    }
}