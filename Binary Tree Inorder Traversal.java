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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        help(res, root);
        
        return res;
    }
    
    public void help(ArrayList<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        help(res, root.left);
        res.add(root.val);
        help(res, root.right);
        
    }
}

非递归 不懂


public ArrayList<Integer> inorderTraversal(TreeNode root) {  
    ArrayList<Integer> res = new ArrayList<Integer>();  
    if(root == null)  
        return res;  
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();  
    while(root!=null || !stack.isEmpty()){  
        if(root!=null){
            stack.push(root);
            root = root.left; 
        }else{  
            root = stack.pop();
            res.add(root.val); 
            root = root.right;  
        }  
    }  
    return res;  
}