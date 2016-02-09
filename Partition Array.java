public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here、
	    int len = nums.length;
	    if(nums == null || len == 0){
	        return 0;
	    }
	    int start = 0;
	    int end = len - 1;
	    //找好start end index， 若start对应值小于k，end大于=k，则更新start end
	    // 否则换位
	    while(start <= end){
	        while(start <= end && nums[start] < k){//根据题意此时不用=k，大于时候才要
	            start++;
	        }
	        while(start <= end && nums[end] >= k){
	            end--;
	        }
	        if(start <= end){
	            int temp = nums[start];
	            nums[start] = nums[end];
	            nums[end] = temp;
	        }
	    }
	    return start;
    }
}


https://github.com/shogunsea/lintcode/blob/master/partition-array.java




public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(ArrayList<Integer> nums, int k) {
	    //write your code here
	    int size = nums.size();
	    if (size == 0) {
	        return 0;
	    }
	    
	    int start = 0;
	    int end = size - 1;
	    
	    while (start <= end) {
	        while (start <= end && nums.get(start) < k) {
	            start++;
	        }
	        while (start <= end && nums.get(end) >= k) {
	            end--;
	        }
	        
	        if (start <= end) {
	            swap(nums, start, end);
    	        start++;
    	        end--;
	        }
	    }
	    return start;
    }
    
    public void swap(ArrayList<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}


