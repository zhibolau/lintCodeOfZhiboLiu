class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int totalLength = A.length + B.length;
        if(totalLength % 2 == 1){
            return findKth(A, 0, B, 0, totalLength/2 + 1);
        }
        return (findKth(A, 0, B, 0, totalLength/2) +
                findKth(A, 0, B, 0, totalLength/2 + 1))/2; 
    }
    
    public static double findKth(int[] A, int AStart, int[] B, int BStart, int k){
        // k is totalLength's median
        int lenA = A.length - AStart;
        int lenB = B.length - BStart;
        // always assume lenA < lenB
        if(lenA > lenB){
            return findKth(B, BStart, A, AStart, k);
        }
        if(lenA == 0){//A is empty
            return B[k - 1];
        }
        if(k == 1){
            return Math.min(A[AStart], B[BStart]);
        }
        //因为AB要合并， 所以到A中k要除以2
        //AKey 就是A中中间那个数
        int partA = Math.min(k/2, lenA);
        int partB = k - partA;
        if(A[AStart + partA - 1] < B[BStart + partB - 1]){
            return findKth(A, AStart + partA, B, BStart, k - partA);
        }
        else if (A[AStart + partA - 1] > B[BStart + partB - 1]){
            return findKth(A, AStart, B, BStart + partB, k - partB);
        }
        else{
            return A[AStart + partA - 1];
        }
    }
        
}

http://www.cnblogs.com/springfor/p/3861890.html


题解：

首先我们先明确什么是median，即中位数。 

引用Wikipedia对中位数的定义：

计算有限个数的数据的中位数的方法是：把所有的同类数据按照大小的顺序排列。如果数据的个数是奇数，则中间那个数据就是这群数据的中位数；如果数据的个数是偶数，则中间那2个数据的算术平均值就是这群数据的中位数。

因此，在计算中位数Median时候，需要根据奇偶分类讨论。

解决此题的方法可以依照：寻找一个unioned sorted array中的第k大（从1开始数）的数。因而等价于寻找并判断两个sorted array中第k/2（从1开始数）大的数。

特殊化到求median，那么对于奇数来说，就是求第(m+n)/2+1（从1开始数）大的数。

而对于偶数来说，就是求第(m+n)/2大（从1开始数）和第(m+n)/2+1大（从1开始数）的数的算术平均值。



那么如何判断两个有序数组A,B中第k大的数呢？

我们需要判断A[k/2-1]和B[k/2-1]的大小。

如果A[k/2-1]==B[k/2-1]，那么这个数就是两个数组中第k大的数。

如果A[k/2-1]<B[k/2-1], 那么说明A[0]到A[k/2-1]都不可能是第k大的数，所以需要舍弃这一半，继续从A[k/2]到A[A.length-1]继续找。当然，因为这里舍弃了A[0]到A[k/2-1]这k/2个数，那么第k大也就变成了，第k-k/2个大的数了。

如果 A[k/2-1]>B[k/2-1]，就做之前对称的操作就好。

 这样整个问题就迎刃而解了。

 

当然，边界条件页不能少，需要判断是否有一个数组长度为0，以及k==1时候的情况。

 

因为除法是向下取整，并且页为了方便起见，对每个数组的分半操作采取：

int partA = Math.min(k/2,m);
int partB = k - partA; 

 为了能保证上面的分半操作正确，需要保证A数组的长度小于B数组的长度。

 

同时，在返回结果时候，注意精度问题，返回double型的就好。 




public static double findMedianSortedArrays(int A[], int B[]) {
    int m = A.length;
    int n = B.length;
    int total = m+n;
    if (total%2 != 0)
        return (double) findKth(A, 0, m-1, B, 0, n-1, total/2+1);//k传得是第k个，index实则k-1
    else {
        double x = findKth(A, 0, m-1, B, 0, n-1, total/2);//k传得是第k个，index实则k-1
        double y = findKth(A, 0, m-1, B, 0, n-1, total/2+1);//k传得是第k个，index实则k-1
        return (double)(x+y)/2;
    }
}
 
public static int findKth(int[] A, int astart, int aend, int[] B, int bstart, int bend, int k) {
    int m = aend - astart + 1;
    int n = bend - bstart + 1;
    
    if(m>n)
        return findKth(B,bstart,bend,A,astart,aend,k);
    if(m==0)
        return B[k-1];
    if(k==1)
        return Math.min(A[astart],B[bstart]);
    
    int partA = Math.min(k/2,m);
    int partB = k - partA;
    if(A[astart+partA-1] < B[bstart+partB-1])
        return findKth(A,astart+partA,aend,B,bstart,bend,k-partA);
    else if(A[astart+partA-1] > B[bstart+partB-1])
        return findKth(A,astart,aend,B,bstart+partB,bend,k-partB);
    else
        return A[astart+partA-1];
    }
	
	
	
	
