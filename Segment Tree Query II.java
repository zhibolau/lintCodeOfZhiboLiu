/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
 看array中在这start end期间的数有几个
 
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root == null || start > end) {
            return 0;
        }
		//找准区间 ！！！！！！！！！！！！！！！！！
        start = Math.max(root.start, start);
        end = Math.min(root.end, end);
        if (root.start == start && root.end == end) {
            return root.count;
        }
        int mid = (root.start + root.end) / 2;//计算mid用的是root的属性
        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start >= mid + 1) {
            return query(root.right, start, end);
        } else {
            return query(root.left, start, mid) + query(root.right, mid + 1, end);//要加在一起算总个数！！！！！！！
        }
    }
}