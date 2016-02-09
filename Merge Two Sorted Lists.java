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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode result = new ListNode(-1);
        ListNode preHead = result;
        while(l1 !=null && l2 != null){
            if(l1.val < l2.val){
                result.next = l1;
                l1 = l1.next;
            }
            else{
                result.next = l2;
                l2 = l2.next;
            }
            
            
            result = result.next;
        }
        while(l1 !=null){
            result.next = l1;
            l1 = l1.next;
            result = result.next;
        }
        while(l2 !=null){
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }
        return preHead.next;
    }
}


自己搞定的！！！！！！！！！！！！！！！！！