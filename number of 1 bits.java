Write a function that takes an unsigned integer and returns the number of ‘1’ bits it has.
 For example, the 32-bit integer ’11’ has binary 
representation 00000000000000000000000000001011, so the function should return 3.

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        while(0 != n)
        {
            n = n&(n - 1); //没次减1后 再& 就会把不同的位变成0 所以看多少次能把n变成0 就有多少次1 
            ++count;
        }

        return count;
    }
}

00000000000000000000000000001011 n
00000000000000000000000000001010 n-1
00000000000000000000000000001010 n&(n-1)

re=1

00000000000000000000000000001010 n
00000000000000000000000000001001 n - 1
00000000000000000000000000001000 n&(n-1)

re = 2

00000000000000000000000000001000 n
00000000000000000000000000000111 n - 1
00000000000000000000000000000000 n&(n-1)

re = 3

return re

