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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        
        if(head == null || n<=0) return null;
        
        ListNode headRemember = new ListNode(0);
        headRemember.next = head;//用来记住头结点
        
        ListNode preDelete = headRemember;//用来跟着head跑，找到被删除元素的前一个元素
        
        for(int i = 0; i < n; i++){
            // 让head往前走n个， 所以head与preDelete相隔n个位置
            if (head  == null){
                return null;
            }
            head = head.next;
        }
        
        while( head != null){
            head = head.next;//
            preDelete = preDelete.next;
        }
        //head此时为最后一个元素/倒数第一个元素， preDelete为倒数第n+1个元素
        preDelete.next = preDelete.next.next;
        return headRemember.next;
    }
}
http://www.jiuzhang.com/solutions/remove-nth-node-from-end-of-list/

