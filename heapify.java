public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        if (A == null || A.length == 0) {
        	return;
        }
        int size = A.length;
        for (int i = size / 2; i >= 0; i--) {//不除以2 的话当前节点的左右两边就会爆出index范围 
		//若是heap 那么当前节点左右孩子就是 2i+1 2i+2 index 不是就得heapify！
        	adjust(A, i);
        }
    }
	//min stack就是 头结点比左右都小  左右关系大小无所谓  http://irwenqiang.iteye.com/blog/1531090
    private void adjust(int[] A, int i) {
    int size = A.length;
    	//while (i < size / 2) {
    		int min = i;
    		int left = i * 2 + 1;
    		int right = i * 2 + 2;
			//只要有值比min小  min的值就更新 min是index
    		if (left < size && A[left] < A[min]) { //A[min] 比左右大 才更新 因为有新min
    			min = left;
    		}
    		if (right < size && A[right] < A[min]) {
    			min = right;
    		}
    		if (i == min) {//说明没被前边的步骤更新min值 
    			return;
    		}
    		swap(A, min, i);//min值改变了 所以要换位置
    		adjust(A, min);
    	//	i = min;
    //	}
    }
    private void swap(int[] A, int i, int j) {
    	int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
}