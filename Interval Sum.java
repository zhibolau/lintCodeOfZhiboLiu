/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
     class SegmentTree{
         int start;
         int end;
         long sum;//因为下边是long
         SegmentTree left;
         SegmentTree right;
         public SegmentTree(int start, int end){
             this.start = start;
             this.end = end;
             this.left = this.right = null;
         }
         public SegmentTree(int start, int end, int sum){
             this.start = start;
             this.end = end;
             this.sum = sum;
             this.left = this.right = null;
         }
     }
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Long> res = new ArrayList<Long>();
        if(A == null || A.length == 0 || 
        queries == null || queries.size() ==0){
            return res; 
        }
        //先build出segment tree 然后再算
        SegmentTree root = build(A, 0, A.length - 1);
        //每一个query都要算sum
        for(Interval i : queries){
            res.add(getSum(root, i.start, i.end));
        }
        
        return res;
    }
    
    public SegmentTree build(int[] A, int start, int end){
        if(A==null || start > end){
            return null;
        }
        if(start == end){
            return new SegmentTree(start, end, A[start]);//因为此区间就一个数 所以sum就是这个数
        }
        int mid = start + (end - start)/2;
        // 此时不确定sum是多少所以先用不带sum的constructor
        SegmentTree root = new SegmentTree(start, end); 
        root.left = build(A, start, mid);
        root.right = build(A, mid+1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    
    public long getSum(SegmentTree root, int start, int end){
        if(root == null || start > end){
            return 0;
        }
        if(root.start == start && root.end == end){
            return root.sum;
        }
        int mid = root.start + (root.end - root.start)/2;
        if(mid >= end){
            return getSum(root.left, start, end);
        }
        else if(start >= mid + 1){
            return getSum(root.right, start, end);
        }
        else{
            return getSum(root.left, start, mid) + getSum(root.right, mid+1, end);
        }
        
    }
}


建立所需class  以及 constructor
要自己建立segmentTree
对于每个query进行getsum操作