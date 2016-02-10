/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return null;
        }
        SegmentTreeNode root = build(A, 0, A.length - 1);
        return root;
    }
    public SegmentTreeNode build(int[] A, int start, int end){
        if(A == null || start > end){
            return null;
        }
        if(start == end){
            return new SegmentTreeNode(start, end, A[start]);
        }
        
        int mid = start + (end - start) /2;
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
        root.left = build(A, start, mid);
        root.right = build(A, mid + 1, end);
        root.max = Math.max(root.left.max, root.right.max);
        return root;
    }
}

此时要的max  以正常build一样！！！！！！！！！！