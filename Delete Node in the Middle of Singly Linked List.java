/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {// 此node不是头结点 是要被删除的点
        // write your code here
    	if (node == null || node.next == null) {
    		node = null;
    		return;
    	}
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
}

