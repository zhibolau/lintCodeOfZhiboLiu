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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head, cur = head.next;
        while(cur !=null){
            ListNode post = cur.next;
            cur.next = pre; //cur.next反向 pre cur都往后走
            pre = cur;
            cur = post;
        }
        head.next = null;
        return pre;
    }
}


自己写的
根据昨晚的reorder list