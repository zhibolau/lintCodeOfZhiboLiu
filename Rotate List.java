public ListNode rotateRight(ListNode head, int n) {

    if (head == null || n == 0)
        return head;
    ListNode p = head;
    int len = 1;//since p is already point to head
    while (p.next != null) {
        len++;
        p = p.next;
    }
    p.next = head; //form a loop
    n = n % len;
    for (int i = 0; i < len - n; i++) { //len - n 为从p走几步到达倒数第k个node
        p = p.next;
    } //now p points to the prev of the new head
    head = p.next;
    p.next = null;
    return head;
}

k是可以大于整个list的长度的，所以这时要对k对len取模

如果取模之后得0，相当于不用rotate，直接返回


把整个list连起来，变成环，找到切分点断开就行。




mine：


/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int n) {
        // write your code here
        if(head == null || n == 0){
            return head;
        }
        ListNode p = head;
        int len = 1; //此时p在head 当前长度为1
        while(p.next != null){
            p = p.next;
            len++;
        }
        //p.next == null now
        p.next = head;// form a loop
        // we need to find the place to break the loop
        // need to go from p by len - n steps
        n = n % len;// if n is bigger than len, then we only 
        //need to walk effective steps not the whole circle
        for(int i = 0; i< len- n; i++){
            p = p.next;
        }
        //now p.next is the place needed to be broken;
        head = p.next;
        p.next = null;
        return head;
    }
}