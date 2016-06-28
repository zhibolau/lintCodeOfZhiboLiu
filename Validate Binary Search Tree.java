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
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        long min = Long.MIN_VALUE;//此处是long 决定 下边isValidBST用long  并且得强制转换成long
        long max = Long.MAX_VALUE;//并且得是用Long来初始化min max
        return isValidBST(root, min, max);
    }
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, (long)root.val) && isValidBST(root.right, (long)root.val, max);
    }
}




//第一种方法是中序遍历法。

//因为如果是BST的话，中序遍历数一定是单调递增的，如果违反了这个规律，就返回false。

public boolean isValidBST(TreeNode root) {  
    ArrayList<Integer> pre = new ArrayList<Integer>();  
    pre.add(null);  
    return helper(root, pre);  
}  
private boolean helper(TreeNode root, ArrayList<Integer> pre)  
{  
    if(root == null)  
        return true; 
    
    boolean left = helper(root.left,pre); 
    
    if(pre.get(pre.size()-1)!=null && root.val<=pre.get(pre.size()-1))  
        return false;  
    pre.add(root.val);  
    
    boolean right = helper(root.right,pre);
    return left && right;  
}

