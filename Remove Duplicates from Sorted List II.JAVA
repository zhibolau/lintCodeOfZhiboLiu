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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode headMem = new ListNode(-1);
        headMem.next = head;
        ListNode pre = headMem;
        ListNode current = headMem.next;
        ListNode post = headMem.next.next;
        
        boolean flag = false;
        
        while(post != null){
            if(current.val == post.val){
                flag = true;
                post = post.next;
                if(post == null){
                    //重复在末尾
                    //current 要被删除
                    pre.next = null;
                }
            }
            else{
                if(flag){
                 //post找到第一个与current不同的元素了
                 //那就删除current到post的前一个元素
                 pre.next = post;
                 flag = false;
                }
                else{
                    //current 与post不等 也没重复
                    //pre cur post就都往前走一步
                    pre = current;
                }
				//有重复了 就 cur 与post 移动， pre不移动，用来删除cur的！！！！！！！！！！！！！！
                current = post;
                post = post.next;
            }
        }
        return headMem.next;
    }
}


http://www.cnblogs.com/springfor/p/3862077.html
讲得好
笔记也有
