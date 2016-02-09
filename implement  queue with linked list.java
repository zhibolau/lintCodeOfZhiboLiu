class Node{
    int val;
    Node next;
    public Node(int i){
        val = i;
        next = null;
    }
}
public class Queue {
    Node head = null, tail = null;
    
    public Queue() {
        // do initialize if necessary
        head = tail;
        
    }

    public void enqueue(int item) {
        // Write your code here
        Node node = new Node(item);
        if(tail != null){
            tail.next = node;
        }
        tail = node;
        if(head == null){
            head = tail;
        }
    }

    public int dequeue() {
        // Write your code here
        int temp = head.val;
        head = head.next;
        return temp;
    }
}