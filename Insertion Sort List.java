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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode node = dummy;//你在node上做的改变  dummy能看见  而不是你重新复制一个dummy node叫node 做改变 而dummy看不见
			//你就是在同一个dummy node做改变 他有个新名称叫node 而已！！！！！！！！！！！！！！！！！！！！！！！！！！！
			//当前node为dummy  dummy的值不算 所以 得看node.next
            while (node.next != null && node.next.val < head.val) {
				//从 dummy的下一个开始 有比head值大的就换位置  大的就去后边了
                node = node.next;
            }
			//有比head值大的就换位置  大的就去后边了
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return dummy.next;
    }
}


真不好理解  画图  干了 5次才明白！！！！    云盘有图！！！
