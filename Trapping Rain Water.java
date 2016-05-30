Trapping Rain Water

30:00
 Start
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

Trapping Rain Water

Have you met this question in a real interview? Yes
Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

看看不同高度的柱体 能存放多少水

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int rst = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, A[left]);//max只能减去在它之后的当前高度 而不会减去之前没遇到的低高度。。。。。。。。。。。。。。。。。。
			//因为left一直往右走 太帅了！  所以不会用当前max减去之前的小高度柱子  只会减去之后遇到的第高度柱子或者同高度柱子
			//遇到再高的就又更新max 再 只会减去之后遇到的第高度柱子或者同高度柱子
			//right同理！ 
            rightMax = Math.max(rightMax, A[right]);
            if (leftMax < rightMax) {
                rst += Math.max(0, leftMax - A[left]);//用左边最大 减去当前高度 获得放水面积 左max小于右max 就让左向右走
                left++;
            } else {
                rst += Math.max(0, rightMax - A[right]);
                right--;
            }
        }
        return rst;
    }
}


跟code走了一遍 就懂了。。。。。。。。。。。。

