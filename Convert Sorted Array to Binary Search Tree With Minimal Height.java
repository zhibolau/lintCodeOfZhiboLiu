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
     * @param A: an integer array
     * @return: a tree node
     */
    
    
    
    
    public TreeNode buildTree(int[] num, int low, int high){
        if(low > high){
            return null;
        }
        //因为是sorted  中间节点就是根节点 然后用递归解决即可
        int mid = (high - low)/2 + low;
        TreeNode node = new TreeNode(num[mid]);
        node.left = buildTree(num, low, mid-1);// 不要再打int[]啦！！！！！！！！1
        node.right = buildTree(num, mid+1, high);
        
        return node;
    }
    
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if(A == null){
            return null;
        }
        return buildTree(A, 0, A.length - 1);//别忘了打return！！！！！！！！！！！
    }
    
}


http://www.cnblogs.com/springfor/p/3879823.html




