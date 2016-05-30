找到下一个升序的!!!!!!permutation


public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's next permuation
     */
    public ArrayList<Integer> nextPermuation(ArrayList<Integer> nums) {
		// write your code
		if (nums == null || nums.size() == 0) {
		    return nums;
		}
		for (int i = nums.size() - 2; i >= 0; i--) {
		    for (int j = nums.size() - 1; j >= i; j--) {
		        if (nums.get(j) > nums.get(i)) {
		            swap(nums, i, j);
		            reverse(nums, i + 1, nums.size() - 1);
		            return nums;
		        }
		    }
		}
		reverse(nums, 0, nums.size() - 1);
		return nums;
    }
    private void swap(ArrayList<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
    private void reverse(ArrayList<Integer> nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}






public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        int len = nums.length;
		if (nums == null || len == 0) {
		    return nums;
		}
		for (int i = len - 2; i >= 0; i--) {//根据题的例子  倒数第二个数 要是小于最后那个数 就swap他俩 再reverse
		//此处reverse不是全部reverse 是局部的 注意！！！！！！！
		    for (int j = len - 1; j >= i; j--) {// j得大于等于i！！！！！！！！！！！！！！
		        if (nums[j] > nums[i]) {
		            swap(nums, i, j);
		            reverse(nums, i + 1, len - 1);
		            return nums;
		        }
		    }
		}
		reverse(nums, 0, len - 1);// 否则 全部reverse
		return nums;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);// 别忘记更新left right！！！！！！！！！！！
        }
    }
    
}



