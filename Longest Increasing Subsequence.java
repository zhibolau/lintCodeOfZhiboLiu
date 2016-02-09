public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int len = nums.length;
        int []f = new int[len]; // 用来记录num中每个元素组成LIS的长度
        int max = 0;
        for (int i = 0; i < len; i++){
            f[i] = 1; // 假设当前的为LIS的开始
            for(int j = 0; j < i; j++){
                // 看到当前为止 能否组成LIS
                //nums[j] 总在nums[i]之前
                if(nums[j] <= nums[i]){// 等于i 也可以算是个起点
                //i前边有一个数必当前i小了
                // i前边有一个数，那个数为0到j之间的
                // 那么我们就得更新记录LIS的array了
                    if (f[i] < f[j] + 1){
                        //因为当前又有一个元素符合LIS了 所以f[j]才加的那个1
                        f[i] = f[j] + 1;
                    }
                    else{
                        f[i] = f[i];
                    }
                } 
            }
            if (f[i] > max){
                max = f[i];
            }
        }
        return max;
    }
}



O(n^2)