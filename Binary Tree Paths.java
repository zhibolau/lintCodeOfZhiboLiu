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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> res = new ArrayList<String>();
        if(root == null){
            return res;
        }
        help(root, String.valueOf(root.val), res);
        return res;
    }
    
    public void help(TreeNode root, String path, List<String> res){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            res.add(path);//path 已经是string 所以直接加入里面
            return;
        }
        if(root.left != null){
            help(root.left, path + "->" + String.valueOf(root.left.val), res);
            
        }
        if(root.right != null){//不能写else  得写明条件内容
            help(root.right, path + "->" + String.valueOf(root.right.val), res);
        }
    }
}