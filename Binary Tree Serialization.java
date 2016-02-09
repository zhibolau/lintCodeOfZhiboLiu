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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    private String rst = new String();
    private int index = 0;
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            rst += "#|";
            return rst;
        }
        rst += String.valueOf(root.val) + "|"; //要把int转化成string
        serialize(root.left);
        serialize(root.right);
        return rst;
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || index == data.length()) { //index等于data长度就超过了 因为index 从0 开始
            return null;
        }
        if (data.charAt(index) == '#') {
            index = index + 2;// 当前为null 下一个应该是|字符 所以也跳过 所以 index+2
            return null;
        }
        int temp = index;
        while (temp < data.length() && data.charAt(temp) != '|') {
            temp++;
        }
        TreeNode root = new TreeNode(Integer.valueOf(data.substring(index, temp)));//要把string转化成int 来建立新的root
        index = temp + 1;
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }
}