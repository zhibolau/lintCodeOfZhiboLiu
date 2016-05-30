Continuous Subarray Sum


Given an integer array, find a continuous subarray where the sum of numbers is the biggest. 
Your code should return the index of the first number and the index of the last number. 
(If their are duplicate answer, return anyone)

Example
Give [-3, 1, 3, -3, 4], return [1,4].

计算array中连续的元素相加最大和 

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return rst;
        }
        int sumSoFar = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        int first = 0;//用来记录 开始的index  最后加到rst中 
        int tempFirst = 0;
        int last = 0;
        for (int i = 0; i < A.length; i++) {
            if(sumSoFar <= 0) {//每一次都可以从下一个元素重新开始算sum 若之前的sumSoFar <= 0 
			//就可以把其设为0 从下一个元素开始加 就不必在加上下一个元素的时候减去sumSoFar了 
			//因为sumSoFar <= 0 就相当于在下一个元素上减去sumSoFar <= 0
                sumSoFar = 0;
                tempFirst = i;
            }
            sumSoFar += A[i];
            if (sumSoFar > sum) {
                sum = sumSoFar;
                first = tempFirst;
                last = i;
            }
        }
        rst.add(first);
        rst.add(last);
        return rst;
    }
}

