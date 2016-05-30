给的是高度
计算与x轴围成的最大面积
public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int volume = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, volume);
			//哪边的高度大就留着 另外一边向其靠近来计算面积
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
mine：

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        int len = heights.length;
        if(heights == null || len <= 1){
            return 0;
        }
        int left = 0, right = len -1, max = 0;
        while(left < right){
            int volume = Math.min(heights[left], heights[right]) * (right - left);
            max = Math.max(max, volume);
            if(heights[left] < heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}