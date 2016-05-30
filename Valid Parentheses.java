看看括号是不是valid的
public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
         if (s == null || s.length() == 0) {
        	return false;
        }
        Stack<Character> stack = new Stack<Character>();//这里是Character  其余是char！！！！！！！！！！！
        String brackets = "([{";
        for (char c : s.toCharArray()) {//要想真 必须得先出现左边的 出现后就push到stack
        	if (brackets.contains(String.valueOf(c))) {
        		stack.push(c);
        	} else if (!stack.isEmpty() && checkMatch(stack.peek(), c)){//要想pop必须得stack不空且 左右呼应
        		stack.pop();
        	} else {
        		return false;
        	}
        }
        return stack.isEmpty();//若stack不空 说明加入后没pop出去 所以不match
    }
    private boolean checkMatch(char c1, char c2) {
    	return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

Have you met this question in a real interview? Yes
Example
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


要想是true 必须得成对出现 且 先左后右
找到成对的括号！！！！
