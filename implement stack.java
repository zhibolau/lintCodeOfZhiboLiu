class Stack {
    //int size;
    int top;
    int[] stackArray;
    public Stack(){
        stackArray = new int[1000];
        top = -1;
    }
    
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here. 
        stackArray[++top] = x;
    }

    // P ;op the top of the stack
    public int pop() {
        // Write your code here
        return stackArray[top--];
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        return stackArray[top];
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return (top == -1);
    }    
}



不好啊 hardcode 的stack的size


可以用两个queue来做

class MyStack {
    LinkedList<Integer> queue1 = new LinkedList<Integer>();
    LinkedList<Integer> queue2 = new LinkedList<Integer>();
 
    // Push element x onto stack.
    public void push(int x) {
        if(empty()){
            queue1.offer(x);
        }else{
            if(queue1.size()>0){
                queue2.offer(x);
                int size = queue1.size();
                while(size>0){
                    queue2.offer(queue1.poll());
                    size--;
                }
            }else if(queue2.size()>0){
                queue1.offer(x);
                int size = queue2.size();
                while(size>0){
                    queue1.offer(queue2.poll());
                    size--;
                }
            }
        }
    }
 
    // Removes the element on top of the stack.
    public void pop() {
        if(queue1.size()>0){
            queue1.poll();
        }else if(queue2.size()>0){
            queue2.poll();
        }
    }
 
    // Get the top element.
    public int top() {
       if(queue1.size()>0){
            return queue1.peek();
        }else if(queue2.size()>0){
            return queue2.peek();
        }
        return 0;
    }
 
    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() & queue2.isEmpty();
    }
}



mine


class Stack {
    LinkedList<Integer> q1= new LinkedList<Integer>();
    LinkedList<Integer> q2= new LinkedList<Integer>();
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        if(isEmpty()){
            q1.offer(x);
        }
        else{
            if(q1.size() > 0){
                q2.offer(x);
                int size = q1.size();
                while(size > 0){
                    q2.offer(q1.poll());
                    size--;
                }
            }
            else if (q2.size() > 0){
                q1.offer(x);
                int size = q2.size();
                while(size > 0){
                    q1.offer(q2.poll());
                    size--;
                }
            }
        }
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if(q1.size() > 0){
             q1.poll();
        }
        else if(q2.size() >0 ){
             q2.poll();
        }
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        if(q1.size() > 0){
            return q1.peek();
        }
        else if(q2.size() >0 ){
            return q2.peek();
        }
        return -1;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q1.isEmpty() && q2.isEmpty();
    }    
}