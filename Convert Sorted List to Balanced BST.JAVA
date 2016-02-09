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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
     
     // why use static??????????
     static ListNode h;
     
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if (head ==null){
            //head.next ==null 不用在此考虑，有一个元素跟有多个元素是一样的 在下面一起处理就可以了
            return null;
        }
        h = head;
        ListNode temp = new ListNode(-1);
        temp = head;
        int len = 0;
        while(temp !=null){
            len++;
            temp = temp.next;
        }
        return sortedListToBST(0, len-1);
    }
    public TreeNode sortedListToBST(int start, int end){
        if(start > end){
            return null;
        }
        int mid = (end-start)/2 + start;
        //由下至上创建树
        TreeNode left = sortedListToBST(start, mid-1);
        TreeNode root= new TreeNode(h.val);
        root.left = left;
        h= h.next;
        TreeNode right = sortedListToBST(mid+1, end);
        root.right = right;
        return root;
    }
}
http://www.cnblogs.com/springfor/p/3884031.html


看笔记吧。。。
