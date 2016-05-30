Remove Duplicates from Sorted Array

删除数组中重复的数字 只留下一个 

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
        int tail = 0;
        for (int i = 1; i < nums.length; i++) {
			 //这是要看第一个 跟第0个是一样的不
            //所以 i从1开始 tail从0开始 
            if (nums[i] != nums[i - 1]) {
                nums[++tail] = nums[i];
            }
        }
        return ++tail;
    }
}


1,1,2 len = 3
0 1 2
i=1
nums[0] = 1 nums[1] = 1
i=2
nums[2] = 2 nums[1] = 1
2 != 1
nums[1] = nums[2] = 2  tail = 1;

return ++1 = 2;