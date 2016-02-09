class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int lenA = A.length;
        int lenB = B.length;
        int lenC = lenA + lenB;
        int [] C = new int[lenC];
        
        int i = lenA - 1;
        int j = lenB - 1;
        int index = lenC - 1;
        
        while(i >= 0 && j >= 0){
            if(A[i] > B[j]){
                C[index--] = A[i--];
            }
            else{
                C[index--] = B[j--];
            }
        }
        while(i>=0){
            C[index--] = A[i--];
        }
         while(j>=0){
            C[index--] = B[j--];
        }
        return C;
    }
}

与 merge sorted array 一样 只不过 自己建了一个数组C
自己做出来的 
哈哈哈
easy
