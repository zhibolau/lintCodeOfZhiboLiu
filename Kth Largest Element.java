Kth Largest Element 
找到数组中第k大的值

Find K-th largest element in an array.


In array [9,3,2,4,8], the 3rd largest element is 4.

In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] numbers) {
        // write your code here
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (i < k) {
                queue.offer(numbers[i]);
            } else {
                if (numbers[i] > queue.peek()) {
                    queue.poll();//把小的删除 放入大的 自动排序
                    queue.offer(numbers[i]);
                }
            }
        }
        return queue.peek();
    }
};


用PQ里放入k个元素  之后的比pq第一个大 就更新 注意 PQ是排序过的自己