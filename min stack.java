public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack; //minStack 就是记录最小元素的
    
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {//把小的加入minStack中
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() {
        minStack.pop(); //？？？？？？？？？？？？？？？？？？
        return stack.pop();
    }

    public int min() {// 返回当前最小元素
        return minStack.peek();
    }
}



public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minStack.empty()){
            minStack.push(number);
        }else{
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() {
        // write your code here
        minStack.pop();// push(1) 时候 stack minStack中都有1 pop时候也都应pop
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
