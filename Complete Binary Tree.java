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
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // Write your code here
         if (root == null) {
          return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean hasNull = false;
        while (!queue.isEmpty()) {
          TreeNode node = queue.poll();
          if (node == null) {//说明当前node无孩子了 所以就有null了
            hasNull = true;
          } else if (hasNull) {
            return false;
          } else {//若在把node都加完之前就有null就说明未把左边的都填满！！！！！！！！！！！！！！！！！！！！！！！！！
            queue.offer(node.left);////这里不是处理root了 是处理当前node 要注意！！！
            queue.offer(node.right);
          }
        }
        return true;
    }
}

offer 比 add要好  add有可能加不入 就会返回exception 
offer则不会 
