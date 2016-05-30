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
 
 //从list找都数第n的node
 
 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        int len = getLen(head);
        if(len == 0 || len < n){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i< n ; i++){
            fast =fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    public int getLen(ListNode n){
        int len = 0;
        while( n != null){
            len ++;
            n = n.next;
        }
        return len;
    }
}

