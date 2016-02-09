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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        int preLen = preorder.length, inLen = inorder.length;
        if(preLen != inLen){
            return null;
        }
        return build(preorder,0,preLen-1, inorder, 0, inLen-1);
        
    }
    public TreeNode build(int[] preorder,int preStart, int preEnd, int[] inorder,
    int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        int rootIndex = 0; 
        for(int i = inStart; i<=inEnd; i++){
            if(inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int len = rootIndex - inStart;
        //preorder root在其头部 所以左子树范围要用prestart+1到preStart + len 因为已经把头部去掉 所以此时用再减1了 index是对的
        root.left = build(preorder, preStart+1, preStart + len, inorder, inStart, rootIndex - 1);
        root.right = build(preorder, preStart + len+1, preEnd, inorder, rootIndex+1, inEnd);
    
        return root;
    }
}