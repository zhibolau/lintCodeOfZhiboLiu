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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp = s.pop();
            if(temp != null){
                res.add(temp.val);//加入的是val  不是node  而stack加入的是node
            }
            if(temp.left != null){
                s.push(temp.left);
            }
            if(temp.right != null){
                s.push(temp.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}

就比preOrder 多了个Collections.reverse(res);



