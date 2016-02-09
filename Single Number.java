http://fisherlei.blogspot.com/2013/11/leetcode-single-number-solution.html

不知道这个题从哪里来的，但是明显是针对计算机专业的。很简单，就是位操作，
任意两个相同的数如果做异或(Exclusive Or)运算的话，结果为0.所以，这题的解法就是这么直白，
从0开始到n，一路异或下去，最后剩下的值就是所求。 

题解：

这道题运用位运算的异或。异或是相同为0，不同为1。所以对所有数进行异或，得出的那个数就是single number。初始时先让一个数与0异或，然后再对剩下读数挨个进行异或。

这里运用到异或的性质：对于任何数x，都有x^x=0，x^0=x

代码如下：

复制代码
1     public int singleNumber(int[] A) {
2         int result = 0;
3         for(int i = 0; i<A.length;i++){
4             result = result^A[i];
5         }
6         return result;
7     }
复制代码
 同时异或还有性质：

 交换律 A XOR B = B XOR A

 结合律 A XOR B XOR C = A XOR (B XOR C) = (A XOR B) XOR C

 自反性 A XOR B XOR B = A XOR 0 = A

所以对于这个数组来说，因为只有一个数字是single的，所以数组可以表示为 a a b b c c d d e。 那么利用上述规律可以异或结果为 0 0 0 0 e。这样写的代码为：

复制代码
1 public static int singleNumber(int[] A) {
2     for (int i = 1; i < A.length; i++) {
3         A[i] ^= A[i-1];
4     }
5     return A[A.length-1];
6 }


http://www.cnblogs.com/springfor/p/3870801.html

