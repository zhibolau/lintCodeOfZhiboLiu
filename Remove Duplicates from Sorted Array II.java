Remove Duplicates from Sorted Array II

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].


public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dup = 1; // 用来记录重复的次数 遇到一个就变为0 所以允许两次重复的
        int tail = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
				//不同的时候  就可以把dup设回1了 
				//因为是sorted array 所以之后遇到的就是不同的数字了
                nums[++tail] = nums[i];
                dup = 1;
            } else if (dup == 1) { // 此处别忘记检查 dup == 1， 说明之前没遇过这个数 
				//此时遇到两个same的元素
                //is allowed
                nums[++tail] = nums[i];
                dup = 0;
            }
        }
        return ++tail;
    }
}


[1,1,1,2,2,3]
 0 1 2 3 4 5

i = 1
nums[1] = nums[0]
dup == 1
nums[1] = nums[1] = 1; dup = 0 tail = 1
i = 2;
nums[2] = 1 nums[1] = 1
dup != 1
so do nothin
i = 3 
nums[3] = 2 nums[2] = 1
nums[2] = nums[3] = 2 tail = 2  dup = 1 因为是sorted array 所以之后遇到的就是不同的数字了

i = 4
