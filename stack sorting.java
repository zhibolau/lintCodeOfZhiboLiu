public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
    	if (stack == null || stack.size() <= 1) {
    		return;
    	}
    	Stack<Integer> helper = new Stack<Integer>();
    	while (stack.size() != 0) {
    		int top = stack.pop();
    		if (helper.size() == 0 || helper.peek() >= top) {//比stack最上边小的 都放在他上边 接下来再进来的比之前的小的也放进入helper中 所以helper中从下到上递减
    			helper.push(top);
    		} else {
    			while (helper.size() != 0 && helper.peek() < top) {
    				stack.push(helper.pop());//若有未在help中的比help最上边的大的元素 就先把 那个小元素放在空stack中
    			}
    			helper.push(top);
    		}
    	}
    	//最后依次把help中的元素都放入stack中  help中比当前stack的都大
    	while (helper.size() != 0) {
    		stack.push(helper.pop());
    	}
    }
}

画个图就懂了