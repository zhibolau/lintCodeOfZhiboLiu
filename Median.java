public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        return findK(nums, 0, size - 1, (size - 1) / 2);
    }
	//找到第k大的数 此时 k= size - 1) / 2， 也就是中位数！！！！！！
    private int findK(int[] nums, int left, int right, int k) {
        Random r = new Random();// Random 要大写！！！！！
        while (left < right) {
            int pivot = partition(nums, left, right, r.nextInt(right - left + 1) + left);//r.nextInt(right - left + 1) + left)   就是想随机找一个地方割开
			//partition 之后 pivotIndex 左边的都比此位置的小 右边的都比他大
            if (pivot == k) {
                return nums[pivot];
            } else if (pivot < k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
		//最后不是left等于k 就是right等于k
        return left == k ? nums[left] : nums[right];
    }
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        int cur = left;
        while (cur <= right) {
            if (nums[cur] < pivotValue) {// 当前值比pivot值小 就把小的放在最左边 因为pivot左边都是比他小的  画图好理解！！！！！
                swap(nums, left++, cur++);
            } else if (nums[cur] == pivotValue) {
                cur++;
            } else {// nums[cur] > pivotValue 所以要把当前cur的值 放在pivot的右边
                swap(nums, cur, right--);
            }
        }
        return left;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}