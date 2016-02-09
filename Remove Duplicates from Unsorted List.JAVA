/**
 * Definition for ListNode
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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head){ 
        // Write your code here
        if (head == null) return null;
        ListNode headRemember = new ListNode(-1);
        headRemember.next = head;
        head = headRemember;
        HashSet<Integer> hash = new HashSet<Integer>();
        
        while(head.next != null){
            if (hash.contains(head.next.val)){
                head.next= head.next.next;
            }
            else{
                hash.add(head.next.val);
                head = head.next;
            }
            
        }
        return headRemember.next;
    }   
}
画图即可 更好理解
