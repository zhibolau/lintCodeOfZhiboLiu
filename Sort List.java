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
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        
        //想用merge sort 得找到list中点
        ListNode slow = head, fast = head;
        ListNode firstHalf = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        
        ListNode leftList =null, rightList = null;
        if(firstHalf != secondHalf){
            leftList = sortList(firstHalf);
            rightList = sortList(secondHalf);
        }
        return woLists(leftList, rightList);    // 名字其实是mergeTwoLists
    }
    
    public ListNode woLists(ListNode leftHead, ListNode rightHead){
        if(leftHead == null){
            return rightHead;
        }
        if(rightHead == null){
            return leftHead;
        }
        ListNode help =new ListNode(-1);
        ListNode ptr = help;
        
        while(leftHead != null && rightHead != null){
            if(leftHead.val > rightHead.val){
                help.next = rightHead;
                help = help.next;
                rightHead = rightHead.next;
            }
            else{
                help.next = leftHead;
                help = help.next;
                leftHead = leftHead.next;
            }
        }
        /*
            if(rightlist!=null)
41             ptr.next = rightlist;
42         if(leftlist!=null)
43             ptr.next = leftlist;     简单写法！！！！！！！！！！！！！
        */
        while(leftHead != null){
            help.next = leftHead;
            help = help.next;
            leftHead = leftHead.next;
        }
        while(rightHead != null){
            help.next = rightHead;
            help = help.next;
            rightHead = rightHead.next;
        }
        
        return ptr.next;
    }
}




http://www.cnblogs.com/springfor/p/3869372.html



