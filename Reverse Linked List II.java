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
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode startPoint = newHead; //startpoint指向需要开始reverse的前一个
        
        ListNode n1 = null; //n1是要被换到后边的
        ListNode n2 = null; //n2是n1.next
        
        for(int i =0; i < n; i++){
            if(i < m-1){
                startPoint = startPoint.next;
            }
            //找到第m个位置的元素
            else if(i == m-1){// else if 要都打出来
                n1 = startPoint.next;//找到第m个元素
                n2 = n1.next;
            }
            else{
                n1.next = n2.next;//n1指向n2后面的那个 
                //n2后边放n1
                n2.next = startPoint.next;// startPoint始终未变 
                // 当i=n-1 是 n2就是第n个元素 让他在startPoint之后就对了
                //把n2放在最开始， 在startPoint后边
                startPoint.next = n2;
                //更新n2为n1的后面
                n2 = n1.next;
            }
        }
        
        return newHead.next;
    }
}



http://www.cnblogs.com/springfor/p/3864303.html


