咋看起来挺简单的一道题目，可之前若是没有接触过神奇的位运算技巧遇到这种题就有点不知从哪入手了，咳咳，我第一次接触到这个题就是在七牛的笔试题中看到的，泪奔 :-(
简单点来考虑可以连除2求余，看最后的余数是否为1，但是这种方法无法在 O(1)O(1) 的时间内解出，所以我们必须要想点别的办法了。2的整数幂若用二进制来表示，则其中必只有一个1，
其余全是0，那么怎么才能用一个式子把这种特殊的关系表示出来了？传统的位运算如按位与、按位或和按位异或等均无法直接求解，我就不卖关子了，比较下x - 1和x的关系试试？以x=4为例。
0100 ==> 4
0011 ==> 3
两个数进行按位与就为0了！如果不是2的整数幂则无上述关系，反证法可证之。


class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if(n < 1){
            return false;
        }
        
        else{
            return (n &(n-1)) ==0;
        }
    }
};


http://algorithm.yuanbin.me/zh-cn/math_and_bit_manipulation/o1_check_power_of_2.html


