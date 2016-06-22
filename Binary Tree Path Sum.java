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
 
 找到sum为target的所有path
 
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root ==null){
            return res;
        }
        List<Integer> items = new ArrayList<Integer>();//用于存放结果
        help(res, items, target, root);
        return res;
    }
    
    public void help(List<List<Integer>> res, List<Integer> items, int target, TreeNode root){
        if(root == null){
            return;
        }
        target -= root.val;
        items.add(root.val);//都target减去root值了 当然要加进去items
        if(root.left == null && root.right == null && target ==0){
            res.add(new ArrayList<Integer>(items));//这里要新建立！！！！！
        }
        else{
            help(res, items, target, root.left);
            help(res, items, target, root.right);
        }
        items.remove(items.size() - 1);//要保证items里面为空 因为要进行新一次的结果计算
    }
}