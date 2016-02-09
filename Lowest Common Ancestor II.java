/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here   
        int length1 = getLength(A);
        int length2 = getLength(B);
        
        int diff = Math.abs(length1 - length2);
        while (diff != 0) {//diff不=0说明 ab不在一层 所以往上更新parent
          if (length1 > length2) {
            A = A.parent;
          } else {
            B = B.parent;
          }
          diff--;
        }
		//此时diff==0说明 ab在同一层 若ab相同 直接return
		//不同 就继续往上找
        while (A != null && B != null && A != B) {// 此地是while 要注意，即使在同层 也不一定就同parent 所以要一直往上找 直到A== B
          A = A.parent;
          B = B.parent;
        }
        return A;
    }
    private int getLength(ParentTreeNode node) {
        int length = 0;
        while (node != null) {
          node = node.parent;
          length++;
        }
        return length;
    }
}