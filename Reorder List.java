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
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return;
        }
        
        //拆分
		/*
			不过这道题要找linkedlist中点，那当然就要用最经典的faster和slower方法，faster速度是slower的两倍，当faster到链尾时，slower就是中点，slower的next是下一半的开始点。
		*/
        ListNode firstHalf = head, slow= head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow= slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;// fast.next.next == null
        secondHalf = reverseList(secondHalf);
		
		//把俩list 交织地加进去
        while(secondHalf != null){
            ListNode t1 = firstHalf.next;
            ListNode t2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = t1;
            firstHalf = t1;
            secondHalf = t2;
        }
    }
    
    //逆序
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;//return head, not null !!!
        }
        ListNode current = head.next;//pre 要与 current 对调
        ListNode preCurr = head;
        while(current != null){
            ListNode post = current.next;
            current.next = preCurr;
            preCurr = current; // preCurr 是被指向的那个结点的前边那个结点，也就是换顺序后的头结点
            current = post;
        }
        head.next = null;
        return preCurr;
    }
}



http://www.cnblogs.com/springfor/p/3869333.html

难！！！！！！！！！！！！！