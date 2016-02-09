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
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null ||head.next == null) 
        return head;
        
        ListNode small = new ListNode(-1);
        ListNode smallHead = small;// 用于将来return的
        ListNode bigEqual = new ListNode(-1);
        ListNode bigEqualHead = bigEqual;//用于将来链接small跟bigEqual的
        
        while(head != null){
            if (head.val < x){
                small.next = head;
                small = small.next;
            }
            else{
                bigEqual.next = head;
                bigEqual = bigEqual.next;
            }
            head = head.next;
        }
        small.next = bigEqualHead.next;
        bigEqual.next = null;
        return smallHead.next;
    }
}

http://www.cnblogs.com/springfor/p/3862392.html

讲得好！！！！！！！！