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
     * @return: Level order a list of lists of integer
     */
    // public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    //     // write your code here
    //     ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
    //     if ( null == root) return result;
    //     levelHelper( root, result );
    //     return result;
    // }
    
    // public void levelHelper(TreeNode root, ArrayList<ArrayList<Integer>> result){
    //     int count = 0; // used to count how many elements there are in the q represented using linkedlist polied by queue
    //     Queue<TreeNode> q = new LinkedList<TreeNode>();
    //     ArrayList<Integer> cur = null;
    //     q.add(root);
    //     while (! q.isEmpty()){
    //         if (count == 0){
    //             count = q.size();
    //             cur = new ArrayList();
    //             result.add(cur);
    //         }
    //         TreeNode n = q.poll();
    //         count--;
    //         cur.add(n.val); //n 为node 要加入他的值
    //         if (n.left != null) q.add(n.left);
    //         if (n.right != null) q.add(n.right);
    //     }
        
    // }
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if (root == null){return result;}
        levelHelp(root, result, 1);
        return result;
        
    }
    public void levelHelp(TreeNode root, ArrayList<ArrayList<Integer>> result, int depth){
        if (root == null) return;
        ArrayList<Integer> temp;
        if (result.size() < depth){
            temp = new ArrayList<Integer>();
            result.add(temp);
        }
        else{
            temp = result.get(depth - 1);
        }
        temp.add(root.val);
        levelHelp(root.left, result, depth +1);
        levelHelp(root.right, result, depth +1);
    }
    
}
