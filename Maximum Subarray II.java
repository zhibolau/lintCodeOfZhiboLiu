
从左往右走一遍找到max
再从右往左走一遍找到max
找到临界点 更新res为max

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int len = nums.size();
        if(nums == null || len <=1){
            return 0;
        }
        //left means 把nums分成两段，从头儿往右走到当前i，max的最大值
        int[] left = new int[len];
        left[0]=nums.get(0);
        for(int i=1; i<len; i++){
            left[i] = Math.max(nums.get(i), left[i-1]+nums.get(i));
        }
        int max=nums.get(0);
        for(int i=1; i<len; i++){
            if(left[i]<max){
                left[i] = max;
            }
            else{
                max = left[i];
            }
        }
        //right means 把nums分成两段，从末尾往左走到当前i，max的最大值
        int[] right = new int[len];
        right[len-1] = nums.get(len-1);
        for(int i=len-2; i>= 0; i--){//当前值 与 之前的值加上当前值 作比较， //当前值或者之前值有可能是负的
            right[i]=Math.max(nums.get(i), right[i+1]+ nums.get(i));
        }
        max=nums.get(len-1);
        for(int i=len-2; i>=0; i--){
            if(right[i]<max){
                right[i] = max;
            }
            else{
                max = right[i];
            }
        }
        //left right不overlap 所以left到i， right到i+1
        int res = Integer.MIN_VALUE;
        for(int i = 0; i<len-1; i++){
            if(res< left[i]+right[i+1]){//right[i+1]
                res= left[i]+right[i+1];
            }
        }
        return res;
    }
}

http://blog.csdn.net/nicaishibiantai/article/details/43637645
思路和股票买卖III一样：
分层两段，左边和右边分别计算max subarray，然后两边加起来最大的就是结果。


http://www.cnblogs.com/lishiblog/p/4183818.html
We need two non-overlapping subarrays, so there must be some point X so that the maximum subarray 
before X (not necessarily end at X) + the maximum subarray after X is max.

So, we first calculate the max subarray end at each point from left to right and from right to left;

Then, we account the max subarray before and after each point;

At last, we find out the result.
