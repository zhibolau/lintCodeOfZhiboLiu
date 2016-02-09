public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 1){
            return 1;// 不是return n， n=0 的时候 有一条路径。。。。。
        }
        int last = 1;
        int lastLast = 1;
        int now = 0;
        for (int i = 2; i<=n; i++){ // n可以被等于
            now = last + lastLast;
            lastLast = last;
            last = now;
        }
        return now;
        
    }
}
