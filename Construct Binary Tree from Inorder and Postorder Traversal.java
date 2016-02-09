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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder.length != postorder.length) {
            return null;
        }
        return buildBST(inorder, 0, inorder.length - 1,
                        postorder, 0, postorder.length - 1);
    }
    private TreeNode buildBST(int[] inorder, int inStart, int inEnd,
                                int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd || poStart > poEnd) {
            return null;
        }
        //k是root index
        int k = findK(inorder, inStart, inEnd, postorder[poEnd]);
        if (k == - 1) {
            return null;
        }
        int leftLength = k - inStart; //root左边的长度
        TreeNode root = new TreeNode(inorder[k]);
        //postorder 右边不好理解！！！！！！！！！！！！！！！！！
        //inorder rootIndex两边分别是左右子树
        //postOrder 左右子树都在rootindex 左边  但长度与inorder一样 左为 poStart, poStart + leftLength - 1
        //postorder 左子树 用减1 因为root在末尾 index从头儿算的 
        root.left = buildBST(inorder, inStart, k - 1, postorder, poStart, poStart + leftLength - 1);
        root.right = buildBST(inorder, k + 1, inEnd, postorder, poStart + leftLen, poEnd - 1);
        return root;
    }
    private int findK(int[] A, int start, int end, int target) {//postOrder最后一个元素为root 所以从
        //inorder中找到与之一样的元素 即为root位置
        for (int i = start; i <= end; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

http://www.cnblogs.com/springfor/p/3884035.html