Write a function that takes an unsigned integer and returns the number of ‘1’ bits it has.
 For example, the 32-bit integer ’11’ has binary 
representation 00000000000000000000000000001011, so the function should return 3.

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        while(0 != n)
        {
            n = n&(n - 1); //每次减1后 再& 就会把不同的位变成0 所以看多少次能把n变成0 就有多少次1 
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



Brute force solution:
Iterate 32 times, each time determining if the ith bit is a ‘1’ or not. This is probably the easiest solution, 
and the interviewer would probably not be too happy about it. This solution is also machine dependent 
(You need to be sure that an unsigned integer is 32-bit). In addition, 
this solution is not very efficient too, as you need to iterate 32 times no matter what.

Lookup table solution:
If you need maximum speed, lookup table is the way to go. Keep in mind that you need a 
huge memory for this. Depending on the maximum bits an integer has, 
you might need up to 4GB of memory to store the table!

Best solution:
Hint: Remember my last post about making use x & (x-1) to determine if an integer is a power of two? 
Well, there are even better uses for that! Remember every time you perform the operation x & (x-1), a single 1 bit is erased?

The following solution is machine independent, and is quite efficient. 
It runs in the order of the number of 1s. In the worst case, 
it needs to iterate 32 times (for a 32-bit integer), but a case such as the number ‘8’ would only need to iterate 1 time.


