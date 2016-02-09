class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        // if (m < n){
        //     return;
        // }
        
        // m可以小于n  size 跟 有效元素个数不是一回事儿
        
        // A有m个元素 最后一个元素index是m-1
        // A.length 是m+n 但是有效元素还是m
        int i = m - 1;
        int j = n - 1;
        int realIndex = m + n - 1;// 也就是A.length - 1， 最后一个位置的index
        
        while(i>=0 && j>=0){
            //从后往前看 比较一个 减减一个 所以i j 最小为0
            if(A[i] > B[j]){
                //谁最大 就放在最后面
                A[realIndex--] = A[i--];
            }
            else{
                A[realIndex--] = B[j--];
            }
        }
        //这时候 A 或者 B 已经完全比完了 就只剩下 A 或B 与realIndex比了
        while(i>=0){
            A[realIndex --] = A[i--];
        }
        
        while(j>=0){
            A[realIndex --] = B[j--];
        }
        
        return;
    }
}

http://www.jiuzhang.com/solutions/merge-sorted-array/


