public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (nums[right] % 2 == 0) {//只要是偶数  右边就不动 就看下一个数
                right--;
            }
			//此时右边是基数
			// 若左边是偶数 正好换位置 不是就看左边的下一个数 ！！！ 逻辑非常好！！！
            if (nums[left] % 2 == 0) {//左边是偶数就换到右边
                swap(nums, left, right--);
            } else {//左边是基数 就看下一个数
                left++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}