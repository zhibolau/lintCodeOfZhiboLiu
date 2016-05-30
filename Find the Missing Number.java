Find the Missing Number
找到第一个缺失的数  按顺序走的话
Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.


Given N = 3 and the array [0, 1, 3], return 2.

public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
    	if(nums==null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for(int i=0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int sumShouldBe = ((nums.length)*(nums.length+1))/2;//为啥从1开始加此时
        return (sumShouldBe - sum);
    }
}