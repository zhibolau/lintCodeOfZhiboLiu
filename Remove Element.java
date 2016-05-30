public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        int tail = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {//不一样就放进去  一样就跳过 只是增加i
                A[++tail] = A[i];
            }
        }
        return ++tail;
    }
}

把数组中出现的这个数都删除掉