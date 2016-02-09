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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    //@param root: The root of binary tree.
    Stack<TreeNode> s = new Stack<TreeNode>(); //注意泛型类型 是treeNode
    TreeNode cur = null;
    public BSTIterator(TreeNode root) {
        // write your code here
        cur = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return cur != null || !s.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        while(cur != null){
            s.push(cur);
            cur= cur.left;
        }
        cur = s.pop();
        TreeNode node = cur;
        cur = cur.right;
        return node;
    }
}
