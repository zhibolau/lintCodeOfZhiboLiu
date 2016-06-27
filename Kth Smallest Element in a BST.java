Kth Smallest Element in a BST



/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */  
public class Solution {  
    public int kthSmallest(TreeNode root, int k) {  
        Stack<TreeNode> stack = new Stack<>();  
        TreeNode n = root;  
        while(n.left!=null) {  
            stack.push(n);  
            n = n.left;   
        }  
          
        while(k>0 && (n!=null || !stack.isEmpty())) {  
            if(n==null) {  
                n = stack.pop();  
                if(--k==0) return n.val;  
                n = n.right;  
            } else {  
                stack.push(n);  
                n = n.left;  
            }  
        }  
        return n.val;  
    }  
} 


