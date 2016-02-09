class Node{
    int val;
    Node next, prev;
    public Node(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
public class Dequeue {
    Node head = null, tail = null;
    public Dequeue() {
        // do initialize if necessary
        head = tail;
    }

    public void push_front(int item) {
        // Write your code here
        Node node = new Node(item);
        node.next = head;
        if(head != null){
            head.prev = node;//原来queue不空
        }
        head = node;//head若是null就让head为当前node  说明原来queue为空
        if(tail == null){
            tail = node;//插入前边 尾部不是null的话就没变化 是null就得挪到当前node上
        }
    }

    public void push_back(int item) {
        // Write your code here
        Node node = new Node(item);
        node.prev =tail;
        if(tail != null){
            tail.next = node;
        }
        tail = node;
        if(head == null){
            head = node;
        }
        
    }

    public int pop_front() {
        // Write your code here
        if(head == null) {
            return -1;
        }
        Node cur = head;
        int val = head.val;
        head = head.next;
        if(head != null){//说明原来queue至少有俩node
            head.prev = null;
        }
        if(cur == tail){//queue只有一个node
            tail = tail.next;
        }
        return val;
    }

    public int pop_back() {
        // Write your code here
        if(tail == null){
            return -1;
        }
        //tail不是null
        Node cur = tail;
        int val = tail.val;
        tail = tail.prev;
        if(tail != null){
            //queue中有至少俩node
            tail.next = null;
        }
        if(cur == head){//queue里只有一个node
            head = head.prev; 
        }
        return val;
    }
}