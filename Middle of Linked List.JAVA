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
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) { 
        // Write your code here
        if(head == null){
            return null;
        }
        ListNode current = head;
        ListNode mid = head;
        int len = 0;
        
        while(current.next != null){
            // current ==null表明 current为最末尾元素
            len++;
            //mid移动为current移动次数的一半！！！！！！！！！！！
            if(len % 2 == 0){
                mid = mid.next;
            }
            //只要len++ current就移动
            current = current.next;
        }
        return mid;
    }
}

http://www.codeproject.com/Articles/1004134/Find-middle-of-a-Linked-List-in-one-pass-Pseudo-co


