Recover Rotated Sorted Array

Given a rotated sorted array, recover it to sorted array in-place.


import java.util.ArrayList;


public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int flag = 0;
        for (int i = 0; i < nums.size() - 1; i++) {// nums.size() - 1 别忘了减1 要不然就出界了 
			//找到那个拐点 
            if (nums.get(i)  > nums.get(i + 1)) {
                flag = i;
            }
        }
		
        if (flag == 0) {//能到这里就说明数是递增的 所以 return
            return;
        }
        reverseList(nums, 0, flag);
        reverseList(nums, flag + 1, nums.size() - 1);//这两次reserse完 list是倒序  再整个reserse就好了
        reverseList(nums, 0, nums.size() - 1);
    }
    private void reverseList(ArrayList<Integer> nums, int start, int end) {
        int length = end +  1 - start;
        for (int i = 0; i < length / 2; i ++) {
            int temp = nums.get(start + i);
            nums.set(start + i, nums.get(end - i));
            nums.set(end - i, temp);
        }
    }
}


