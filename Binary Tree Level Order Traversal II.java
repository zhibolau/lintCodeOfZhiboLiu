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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if (root == null){return result;}
        levelHelp(root, result, 1);
        Collections.reverse(result); //与I 就是多了这行 反向存储了 
        return result;
    }
    
    public void levelHelp(TreeNode root, ArrayList<ArrayList<Integer>> result, int depth){
        if (root == null) return;
        ArrayList<Integer> temp; //用于存储当前层的元素
        if (result.size() < depth){
            temp = new ArrayList<Integer>();
            result.add(temp);
        }
        else{//相等时候 说明 我还要继续往当前层加入元素 所以先获得当前层的那个arrayList
            temp = result.get(depth - 1);//这里是depth - 1 不是res的size！！！！
        }
        temp.add(root.val);
        levelHelp(root.left, result, depth +1);
        levelHelp(root.right, result, depth +1);
    }
}