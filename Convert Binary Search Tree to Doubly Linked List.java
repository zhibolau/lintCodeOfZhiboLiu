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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if (root == null) {
            return null;
        }
        DoublyListNode rootNode = new DoublyListNode(root.val);
        if (root.left == null && root.right == null) {
            return rootNode;
        }
        DoublyListNode left = bstToDoublyList(root.left);
        DoublyListNode right = bstToDoublyList(root.right);
        rootNode.next = right;
        if (right != null) {
            right.prev = rootNode;
        }
        if (left != null) {
			//DoublyList 最后left就是head！！！！！！
            DoublyListNode dummy = left;//dummy用来记录head！！！  别忘记dummy  ！！！！！！！！！！！！！！！！！！！！！！！
            while (left.next != null) {
				//一直走 走到left的下一个是null  这时候就要链接left与rootNode了
                left = left.next;
            }
            left.next = rootNode;
            rootNode.prev = left;
            return dummy;
        } else {
            return rootNode;
        }
    }
}