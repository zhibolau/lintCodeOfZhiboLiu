The Smallest Difference

30:00
 Start
Given two array of integers(the first array is array A, the second array is array B),
 now we are going to find a element in array A which is A[i], and another element in array 
 B which is B[j], so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.

Have you met this question in a real interview? Yes
Example
For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0


找两个ARRAY中 元素相差最小的是几

public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        Arrays.sort(A);//别忘记sort 所以才知道下边 index怎么增加 减少
        Arrays.sort(B);
        int indexA = 0;
        int indexB = 0;
        int minDiff = Integer.MAX_VALUE;;
        while (indexA != A.length && indexB != B.length) {
            minDiff = Math.min(minDiff, Math.abs(A[indexA] - B[indexB]));
            if (A[indexA] <= B[indexB]) {
                indexA++;
            } else {
                indexB++;
            }
        }
        return minDiff;
    }
}

