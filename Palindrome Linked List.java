/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 看看当前list 是不是回文linked list
 
 
public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        // Write your solution here.
        if (head == null || head.next == null) {
          return true;
        }
        ListNode mid = findMid(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        while (head != null && tail != null) {// 是head 与 tail 一起往后走  从头开始！！！！！！
          if (head.val != tail.val) {
            return false;
          }
          head = head.next;
          tail = tail.next;
        }
        return true;
  }
  private ListNode findMid(ListNode head) {// 找中点 就弄俩node 一个快一个慢   画图好理解
        if (head == null || head.next == null) {
          return head;// RETURN的是head  不是null！！！！！！！！！ 
		  // head.next是null  你也不能直接return null 要return head

        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
          slow = slow.next;
          fast = fast.next.next;
        }
        return slow;
  }
  private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
          return head;// RETURN的是head  不是null！！！！！！！！！
        }
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
          ListNode next = cur.next;
          cur.next = prev;
          prev = cur;
          cur = next;
        }
        return prev;
    }
}
