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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return rst;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int count = queue.size();//看看当前层应该加入几个到items
            ArrayList<Integer> items = new ArrayList<Integer>();//注意类型是integer  不是 treenode
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();//因为每次都要看当前node的左右有无孩子 所以要放在loop内
                items.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
			//因为左右交替进行  root这次算是从左至右  所以去else 设置成true  下次 就会 reverse了！！！
            if(reverse){
                 Collections.reverse(items);
                 reverse = false;
             }else{
                 reverse = true;
             }
            rst.add(items);
            
        }
        return rst;
    }
}