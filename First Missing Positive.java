First Missing Positive

找到第一个确实的正整数
Given an unsorted integer array, find the first missing positive integer.

Example
Given [1,2,0] return 3,
and [3,4,-1,1] return 2
题解：

题目给了一个unsorted integer array。当然，可以用先排好序的方法走（但是时间复杂度就不能是O（n）)。

所以这里提供一个不先排序的算法。

 

注意：题目要求是find the first missing positive integer 。

也就是说，即便你给的数组是4 5 6 7，看似都一一排好序，但是返回值一定是1，也就是如果给的数组是4 5 7 8 ，答案不是6，是1。

 

因此，有了这个性质，我们就能i和A[i]是否相等来做判断了。“实现中还需要注意一个细节，就是如果当前的数字所对应的下标已经是对应数字了，
那么我们也需要跳过，因为那个位置的数字已经满足要求了，否则会出现一直来回交换的死循环。”引自 Code Ganker

交换数组元素，使得数组中第i位存放数值(i+1)。最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。整个过程需要遍历两次数组，复杂度为O(n)。

桶排序，每次当A[i]!= i+1的时候，将A[i]与A[A[i]-1]交换，直到无法交换位置。终止条件是 A[i]== A[A[i]-1]。


public int firstMissingPositive(int[] A) {
        for(int i=0;i<A.length;i++){
        	while(A[i]!=i+1){
				//以下情况不用换位置
				//A[i] 不在 1 到 A.length-1 之间 或者 A[i] = i + 1（相当于  A[i]==A[A[i]-1]）
        		if(A[i]<=0 ||A[i]>=A.length|| A[i]==A[A[i]-1]) break;
				//此时说明A[i]这个数在1到A.length-1 之间但是没在正确位置
				//so换位置
				//因为 A[i]!=i+1 但是我们要让 A[i]=i+1
        		int temp = A[i];
        		A[i] = A[A[i]-1];
        		A[temp-1] = temp;//把A[i]放在A[A[i]-1]  举个例子就明白了 可以用[4,5,6,7]
        	}
        	
        }
        for(int i=0;i<A.length;i++){
        	if(A[i]!=i+1)
        		return i+1;
        }
        return A.length+1;
    }
	
	
	
	

