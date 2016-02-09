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
     int max = Integer.MIN_VALUE;
     
    public int maxPathSum(TreeNode root) {
        // write your code here
        
        dfs(root); //这个地方return了 那下边的return不就没用了？？？？？？？？？？？？？
		
        return max;
        
    }
    public int dfs(TreeNode root){
        if (null == root) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int temp = root.val + ((l > 0)? l :0) + ((r > 0)? r :0); // l r 都取
        if (temp > max) max = temp;
        return root.val + Math.max(0, Math.max(l,r)); //??????????????????  l r只取一个？？？？？？？？？？
    }
}
