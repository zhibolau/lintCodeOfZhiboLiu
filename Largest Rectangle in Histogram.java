public int largestRectangleArea2(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[i] >= h[stack.peek()]){//当前指向元素值比stack顶的大就push进去
			// 保持 stack中的高度是单调递增的
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
	
	
	
	http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
	
	
	
	例如我们遇到最后遇到一个递减的bar（红色）。高度位于红线上方的（也就是算法中栈里面大于最右bar的）元素，他们是不可能和最右边的较小高度bar围成一个比大于在弹栈过程中的矩形面积了（黄色面积），因为红色的bar对他们来说是一个短板，和红色bar能围成的最大面积也就是红色的高度乘以这些“上流社会”所跨越的索引范围。但是“上流社会”的高度个个都比红色bar大，他们完全只计算彼此之间围成的面积就远远大于和红色bar围成的任意面积了。所以红色bar是不可能参与“上流社会”的bar的围城的（好悲哀）。

但是屌丝也不用泄气哦。因为虽然长度不占优势，但是团结的力量是无穷的。它还可以参与“比较远的”比它还要屌丝的bar的围城。他们的面积是有可能超过上流社会的面积的，因为距离啊！所以弹栈到比红色bar小就停止了。


那h[t]无疑就是Stack.Peek和t之间那些上流社会的短板啦，而它们的跨越就是i - Stack.Peek - 1。

所以说，这个弹栈的过程也是维持程序不变量的方法啊：栈内元素一定是要比当前i指向的元素小的。