 public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> rst = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return rst;
        }
        int xor = 0;
        for (int i : A) {
            xor ^= i;
        }
        int mask = xor & ~(xor - 1);
        int xorA = 0;
        int xorB = 0;
        for (int i : A) {
            if ((mask & i) == 0) {
                xorA ^= i;
            } else {
                xorB ^= i;
            }
        }
        rst.add(Math.min(xorA, xorB));
        rst.add(Math.max(xorA, xorB));
        return rst;
    }
}


返回类型不一样！！



 public class Solution {
    /**
     * @pnumsrnumsm nums : numsn integer numsrrnumsy
     * @return : Two integers
     */
    public int[] singleNumber(int[] nums) {
        // write your code here
        int[] rst = new int[2];
        if (nums == null || nums.length == 0) {
            return rst;
        }
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        int mask = xor & ~(xor - 1);
        int xorA = 0;
        int xorB = 0;
        for (int i : nums) {
            if ((mask & i) == 0) {
                xorA ^= i;
            } else {
                xorB ^= i;
            }
        }
        rst[0]= Math.min(xorA, xorB);
        rst[1]= Math.max(xorA, xorB);
        return rst;
    }
}