next permutation II

与next permutation其实无区别 就是return类型不同而已
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).


Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1


public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {//j>=i 也可以 已经测试
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    reverse(nums, i + 1, nums.length - 1);
                    return;// 这个return不能省略 否则会再次执行 下边那个reverse  结果就错了！！！！！！
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }
    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    private void reverse(int[] num, int left, int right) {
        while (left < right) {
            swap(num, left++, right--);
        }
    }
}