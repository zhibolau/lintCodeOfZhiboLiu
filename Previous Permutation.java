Previous Permutation

Given a list of integers, which denote a permutation.

Find the previous permutation in ascending order.

The list may contains duplicate integers.

For [1,3,2,3], the previous permutation is [1,2,3,3]

For [1,2,3,4], the previous permutation is [4,3,2,1]

找到在这个permutation按照升序排序的上一个permutation  


import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public void swapItem(ArrayList<Integer> nums, int i, int j) {
		Integer tmp = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, tmp);
	}
	public void swapList(ArrayList<Integer> nums, int i, int j) {
		while ( i < j) {
			swapItem(nums, i, j);
			i ++; j --;
		}
	}
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		int len = nums.size();
		if ( len <= 1)
			return nums;
		int i = len - 1;
		while ( i > 0 && nums.get(i) >= nums.get(i-1) ){//找到前一个比后边大的那个
			i --;
		}
		swapList(nums, i, len - 1);     
		if ( i != 0) {
			int j = i;
			while ( nums.get(j) >= nums.get(i-1) ){//找到前一个比后边大的那个
				j++;
			}				
			swapItem(nums, j, i-1);
		}
		
		return nums;
    }
}


1323
len = 4
i = 3 i - 1 = 2
nums[i] = 3 nums[i-1] = 2
3>2
i-- i = 2 i - 1 = 1
nums[2] = 2 
nums[1] = 3
2<3
so reverse(1323, 2,3)  ===> 1332
i != 0
j = 2
nums[2] = 3 nums[1] = 3
j++ j = 3
nums[3] = 2 < nums[2] = 3
swap(1332, 3, 1) ==> 1233


