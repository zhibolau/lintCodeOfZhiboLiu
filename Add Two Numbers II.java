/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
 
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
     private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        l1 = reverse(l1);
        l2 = reverse(l2);
        return reverse(addList1(l1, l2));
    }  
    public ListNode addList1(ListNode l1, ListNode l2) {
        // write your code here
        ListNode head = new ListNode(-1);
        ListNode point = head;
        int carry = 0;
        int sum = 0;
        while(l1 != null && l2 != null){
            sum = carry + l1.val + l2.val;
            carry = sum/10;
            point.next = new ListNode(sum%10);
            point = point.next;
            l1= l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            sum = carry + l1.val;
            carry = sum/10;
            point.next = new ListNode(sum%10);
            point = point.next;
            l1= l1.next;
        }
        while(l2 != null){
            sum = carry + l2.val;
            carry = sum/10;
            point.next = new ListNode(sum%10);
            point = point.next;
            l2 = l2.next;
        }
        if(carry !=0){
            point.next = new ListNode(carry);
        }
        return head.next;
    }
}