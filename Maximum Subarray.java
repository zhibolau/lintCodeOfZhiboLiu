public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        int maxEndsHere= 0;//初始值 这时候还没加入任何nums中元素
        int maxSoFar = Integer.MIN_VALUE; //多引入maxSoFar来判断是否更新当前max， 因为nums中有可能有负数 此时就不用更新max
        int len = nums.length;
        
        for(int i = 0; i < len; i++){
            //maxEndsHere 有可能小于零 nums中有可能有负数
            if(maxEndsHere < 0){
                // 负数只能使 max变小， 有负数 0就是最大， 负数就不往里面加， 所以 max就是0
                maxEndsHere = 0; 
            }
            maxEndsHere = maxEndsHere + nums[i];
            maxSoFar= Math.max(maxSoFar, maxEndsHere);
        }
        return maxSoFar;
    }
}

http://www.cnblogs.com/springfor/p/3877058.html


这个方法也好：


题解：

 这道题要求 求连续的数组值，加和最大。

 试想一下，如果我们从头遍历这个数组。对于数组中的其中一个元素，它只有两个选择：

 1. 要么加入之前的数组加和之中（跟别人一组）

 2. 要么自己单立一个数组（自己单开一组）

 所以对于这个元素应该如何选择，就看他能对哪个组的贡献大。如果跟别人一组，能让总加和变大，还是跟别人一组好了；如果自己起个头一组，自己的值比之前加和的值还要大，那么还是自己单开一组好了。

所以利用一个sum数组，记录每一轮sum的最大值，sum[i]表示当前这个元素是跟之前数组加和一组还是自己单立一组好，然后维护一个全局最大值即位答案。

 

代码如下；

复制代码
 1     public int maxSubArray(int[] A) {
 2         int[] sum = new int[A.length];
 3         
 4         int max = A[0];
 5         sum[0] = A[0];
 6  
 7         for (int i = 1; i < A.length; i++) {
 8             sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
 9             max = Math.max(max, sum[i]);
10         }
11  
12         return max;
13     }
复制代码
 
 
 
 