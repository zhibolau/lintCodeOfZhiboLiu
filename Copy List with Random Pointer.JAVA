/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head ==null){
            return null;
        }
        //建立重复链表 新旧交替
        RandomListNode node = head; //node用来跑表 遍历表
        while(node != null){
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node=newNode.next;
        }
        //此时node == null 从while loop跳出来了
        node = head;
        // 给新表复制 random
        while(node !=null){
            if(node.random !=null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        //此时node == null 从while loop跳出来了
        RandomListNode newHead = head.next;
        node = head;
        //拆分新旧list
        while(node != null){
            //newNode 用来遍历新list
            RandomListNode newNode = node.next;
            //node.next为newNode的下一个， 因为新旧表node相隔
            node.next = newNode.next;
            if (newNode.next != null){
                //newNode.next为当前node的下一个的下一个， 因为新旧表node相隔
                newNode.next = newNode.next.next;
            }
            //把node移动两个 第一个为newNode
            node =node.next;
        }
        return newHead;
    }
}
http://www.cnblogs.com/springfor/p/3864457.html

笔记右图  一步步走  好难！