Given an array of n positive integers and a positive integer s, find the minimal length of a 
subarray of which the sum ≥ s. If there isn't one, return -1 instead.

Have you met this question in a real interview? Yes
Example
Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.

找到array中和为s的最少元素数

public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int len = nums.length;
        if(nums == null || len == 0){
            return -1;
        }
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(start < len && end <len){
            while(end < len && sum < s){
                sum += nums[end++];
            }
            while(start < len && sum >= s){
                min = Math.min(min, end - start);
                sum -= nums[start++];
            }
        }
        return min == Integer.MAX_VALUE? -1 : min;
    }
}

