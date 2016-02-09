public class Queue {
    //Stack 是在表尾进行处理的数据结构 先进先出
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void stack2ToStack1() {//把stack2放入stack1中 并清空stack2
        while(! stack2.empty()){
            stack1.push(stack2.peek());
            stack2.pop();
        }
    }
    public void push(int element) {//放入stack并返回元素
        // write your code here
        stack2.push(element);
    }

    public int pop() {//返回并删除当前元素
        // write your code here
        if(stack1.empty() == true){
            this.stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {//返回不删除当前元素
        // write your code here
        if(stack1.empty() == true){
            //若当前stack无元素 就要把stack2中元素放进来
            this.stack2ToStack1();
        }
        return stack1.peek();
    }
}